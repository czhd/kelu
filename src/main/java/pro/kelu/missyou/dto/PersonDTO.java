package pro.kelu.missyou.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import pro.kelu.missyou.validators.PasswordEqual;

@Getter
@Setter
//@Builder
//@Data
@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
@PasswordEqual
public class PersonDTO {

    private Integer age;
    @Length(min = 1, max = 10, message = "只能1~10范围内噢")
    private String name;

    private String password1;

    private String password2;
}
