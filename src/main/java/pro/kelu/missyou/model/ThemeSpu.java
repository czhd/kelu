package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
public class ThemeSpu extends BaseEntity {
    @Id
    private int id;
    private int themeId;
    private int spuId;


}
