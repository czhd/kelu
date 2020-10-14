package pro.kelu.missyou.service;

import pro.kelu.missyou.model.BannerModel;

public interface BannerService {
    BannerModel getByName(String name);
}
