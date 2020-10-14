package pro.kelu.missyou.model;

import javax.persistence.*;

@Entity
public class BannerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String img;
    private String keyword;
    private short type;
    private String name;

    private Long bannerId;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT), insertable = false, updatable = false, name = "bannerId")
    private BannerModel banner;
}
