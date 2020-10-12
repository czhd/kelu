package pro.kelu.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${missyou.api-package}")
    private String apiPackageName;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
        if (requestMappingInfo != null) {
            String prefix = this.getPrefix(handlerType);
            return RequestMappingInfo.paths(prefix)
                    .build()
                    .combine(requestMappingInfo);
        }
        return requestMappingInfo;
    }

    private String getPrefix(Class<?> handlerType) {
        String packName = handlerType.getPackage().getName();
        String dopath = packName.replace(this.apiPackageName, "");
        return dopath.replace(".", "/");
    }
}
