package pro.kelu.missyou.model;

import javax.persistence.*;

@Entity
@Table(name = "banner1")
public class BannerModel {

    @Id
    private long id;
    @Column(length = 20)
    private String name;
    @Transient
    private String description;
    private String title;
    private String image;
}
