package pro.kelu.missyou.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banner")
public class BannerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20)
    private String name;
    @Transient
    private String description;
    private String title;
    private String img;

    //fetch = FetchType.EAGER 急加载
    @OneToMany(mappedBy = "banner", fetch = FetchType.EAGER)
    //关联外键
//    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;

    //双向一对多，一端为被维护方，关联外键打在多端，mappedBy
}
