package pro.kelu.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.bo.PageCounter;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.service.SpuService;
import pro.kelu.missyou.util.CommonUtil;
import pro.kelu.missyou.vo.Paging;
import pro.kelu.missyou.vo.PagingDozer;
import pro.kelu.missyou.vo.SpuSimplifyVO;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive long id) {
        Spu spu = spuService.getSpuById(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") int start,
                                                @RequestParam(defaultValue = "10") int count) {
//        return spuService.getLatestPaginateSpu();
        PageCounter pageCounter = CommonUtil.converToPageParameter(start, count);
        Page<Spu> spuPage = spuService.getLatestPaginateSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(spuPage, SpuSimplifyVO.class);
    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategoryId(@PathVariable @Positive long id,
                                                      @RequestParam(name = "is_root", defaultValue = "false") boolean isRoot,
                                                      @RequestParam(defaultValue = "0") int start,
                                                      @RequestParam(defaultValue = "10") int count) {
        PageCounter pageCounter = CommonUtil.converToPageParameter(start, count);
        Page<Spu> spuPage = spuService.getByCategory(id, isRoot, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(spuPage, SpuSimplifyVO.class);
    }
}
