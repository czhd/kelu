package pro.kelu.missyou.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("lin")
@PropertySource("classpath:config/exception-code.properties")
@Component
public class ExceptionConfigConfiguration {
    private Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    public String getMessage(int code) {
        return codes.get(code);
    }
}
