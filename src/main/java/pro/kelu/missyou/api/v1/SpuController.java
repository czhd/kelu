package pro.kelu.missyou.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.service.SpuService;

import javax.validation.constraints.Positive;
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
    public List<Spu> getLatestSpuList() {
        return spuService.getLatestPaginateSpu();
    }
}
