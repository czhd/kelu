package pro.kelu.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {
    String message() default "密码不一致";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //关联类

}
