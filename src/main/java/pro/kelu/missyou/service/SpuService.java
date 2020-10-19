package pro.kelu.missyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.repository.SpuRepository;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;

    public Spu getSpuById(long id) {
        return spuRepository.findOneById(id);
    }

    public Page<Spu> getLatestPaginateSpu(int page, int count) {
        Pageable pageable = PageRequest.of(page, count, Sort.by("createTime").descending());
        return spuRepository.findAll(pageable);
    }

    public Page<Spu> getByCategory(long cid, boolean isRoot, int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        if (isRoot) {
            return spuRepository.findByRootCategoryIdOrderByCreateTime(cid, pageable);
        } else {
            return spuRepository.findByCategoryIdOrderByCreateTime(cid, pageable);
        }
    }
}
