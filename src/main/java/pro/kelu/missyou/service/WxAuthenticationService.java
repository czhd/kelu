package pro.kelu.missyou.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pro.kelu.missyou.exception.http.ParameterException;
import pro.kelu.missyou.model.User;
import pro.kelu.missyou.repository.UserRepository;
import pro.kelu.missyou.util.GenericAndJson;
import pro.kelu.missyou.util.JwtToken;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WxAuthenticationService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;


    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String secret;

    @Value("${wx.code2session}")
    private String code2SessionUrl;

    public String codeToToken(String code) {
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.secret, code);
        RestTemplate rest = new RestTemplate();
        String sessionText = rest.getForObject(url, String.class);
        Map<String, Object> map = new HashMap<>();
        try {
            map = objectMapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(map);
    }

    public String registerUser(Map<String, Object> session) {
        String openid = (String) session.get("openid");
        if (openid == null) {
            throw new ParameterException(20004);
        }
        User user = userRepository.findByOpenid(openid);
        if (user != null) {
            // TODO: JWT
            return JwtToken.makeToken(user.getId());
        }
        user = User.builder()
                .openid(openid)
                .build();
        userRepository.save(user);
        // TODO: JWT
        Long uid = user.getId();
        return JwtToken.makeToken(uid);
    }
}
