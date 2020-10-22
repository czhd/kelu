package pro.kelu.missyou.util;

import org.springframework.beans.factory.annotation.Value;

public class JwtToken {
    @Value("${missyou.security.jwt-key}")
    private String jwtKey;
}
