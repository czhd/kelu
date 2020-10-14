package pro.kelu.missyou.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.model.BannerModel;
import pro.kelu.missyou.service.BannerService;

import javax.validation.constraints.NotBlank;

//@Controller
@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public BannerModel name(@PathVariable @NotBlank String name) {
        BannerModel bannerModel = bannerService.getByName(name);
        return bannerModel;
    }
}
