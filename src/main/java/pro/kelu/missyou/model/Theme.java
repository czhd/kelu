package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Theme extends BaseEntity{
    @Id
    private Long id;
    private String title;
    private String description;
    private String name;
    private String tplName;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;


    @ManyToMany
    @JoinTable(name = "theme_spu", joinColumns = @JoinColumn(name = "themeId"), inverseJoinColumns = @JoinColumn(name = "spuId"))
    private List<Spu> spuList;

}
