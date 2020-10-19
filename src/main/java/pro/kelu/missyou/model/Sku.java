package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;
import pro.kelu.missyou.util.ListAndJson;
import pro.kelu.missyou.util.MapAndJson;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;

    @Convert(converter = ListAndJson.class)
    private List<Object> specs;
    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;


}
