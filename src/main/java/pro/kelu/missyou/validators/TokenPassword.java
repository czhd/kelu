package pro.kelu.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    String message() default "字段要求不正确";

    int min() default 6;

    int max() default 32;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
