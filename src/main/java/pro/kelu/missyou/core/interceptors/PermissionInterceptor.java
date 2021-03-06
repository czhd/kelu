package pro.kelu.missyou.core.interceptors;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pro.kelu.missyou.exception.http.ForbiddenException;
import pro.kelu.missyou.exception.http.UnAuthenticatedException;
import pro.kelu.missyou.util.JwtToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
    public PermissionInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if (!scopeLevel.isPresent()) {
            return true;
        }
        String token = this.getToken(request);
        Optional<Map<String, Claim>> optionalMap = JwtToken.getClaims(token);
        Map<String, Claim> map = optionalMap.orElseThrow(
                () -> new UnAuthenticatedException(10004)
        );
        return this.hasPermission(scopeLevel.get(), map);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private Optional<ScopeLevel> getScopeLevel(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            if (scopeLevel == null) {
                return Optional.empty();
            }
            return Optional.of(scopeLevel);
        }
        return Optional.empty();
    }

    private String getToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isEmpty(bearerToken)) {
            throw new UnAuthenticatedException(10004);
        }
        if (!bearerToken.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }
        String[] token = bearerToken.split(" ");
        if (token.length < 2) {
            throw new UnAuthenticatedException(10004);
        }
        return token[1];
    }

    private Boolean hasPermission(ScopeLevel scopeLevel, Map<String, Claim> map) {
        int level = scopeLevel.value();
        int scope = map.get("scope").asInt();
        if (level > scope) {
            throw new ForbiddenException(10005);
        }
        return true;
    }
}
