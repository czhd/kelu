package pro.kelu.missyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.kelu.missyou.model.BannerModel;
import pro.kelu.missyou.repository.BannerRepository;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public BannerModel getByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
