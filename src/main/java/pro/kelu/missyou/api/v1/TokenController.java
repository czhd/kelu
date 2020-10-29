package pro.kelu.missyou.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.TokenDTO;
import pro.kelu.missyou.dto.TokenGetDTO;
import pro.kelu.missyou.service.WxAuthenticationService;
import pro.kelu.missyou.util.JwtToken;

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
                token = wxAuthenticationService.codeToToken(tokenGetDTO.getAccount());
                break;
            case USER_EMAIL:
                token = "";
                break;
            default:
                break;
        }
        map.put("token", token);
        return map;
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verify(@RequestBody TokenDTO token) {
        Map<String, Boolean> map = new HashMap<>();
        Boolean valid = JwtToken.verifyToken(token.getToken());
        map.put("is_valid", valid);
        return map;
    }
}
