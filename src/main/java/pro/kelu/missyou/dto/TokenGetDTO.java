package pro.kelu.missyou.dto;

import lombok.Getter;
import lombok.Setter;
import pro.kelu.missyou.core.enumeration.LoginType;
import pro.kelu.missyou.validators.TokenPassword;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDTO {
    @NotBlank(message = "account不能为空")
    private String account;

    @TokenPassword
    private String password;

    private LoginType loginType;
}
