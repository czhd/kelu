package pro.kelu.missyou.core.enumeration;

public enum LoginType {
    USER_WECHAT(0, "微信登录"),
    USER_EMAIL(1, "邮箱登录");

    private Integer value;

    LoginType(Integer value, String description) {
        this.value = value;
    }
}
