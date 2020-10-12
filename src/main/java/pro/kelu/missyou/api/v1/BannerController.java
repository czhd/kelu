package pro.kelu.missyou.api.v1;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.PersonDTO;

import javax.validation.constraints.Max;

//@Controller
@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {


    @PostMapping("/test/{id}")
    public PersonDTO test(@PathVariable @Max(value = 10, message = "只能1~10范围内噢") int id,
                       @RequestParam @Length(min=10) String name,
                       @RequestBody @Validated PersonDTO person) {
        PersonDTO dto = new PersonDTO();
        return dto;

//        throw new NotFoundException(10001);
    }
}
