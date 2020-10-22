package pro.kelu.missyou.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.TokenGetDTO;
import pro.kelu.missyou.service.WxAuthenticationService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/token")
public class TokenController {

    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping("")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDTO tokenGetDTO) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (tokenGetDTO.getLoginType()) {
            case USER_WECHAT:
                String it = "sss";

                wxAuthenticationService.codeToToken(tokenGetDTO.getAccount());
                break;
            case USER_EMAIL:

                break;
            default:
                break;
        }
        
        return null;
    }
}
