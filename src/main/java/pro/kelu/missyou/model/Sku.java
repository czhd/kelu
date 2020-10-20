package pro.kelu.missyou.model;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;
import pro.kelu.missyou.util.GenericAndJson;
import pro.kelu.missyou.util.ListAndJson;
import pro.kelu.missyou.util.MapAndJson;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
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

    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;

//    @Convert(converter = ListAndJson.class)
//    private List<Object> specs;

    private String specs;

    public List<Spec> getSpecs() {
        if (this.specs == null) {
            return Collections.emptyList();
        }
        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>() {
        });
    }

    public void setSpecs(List<Spec> specs) {
        if (specs.isEmpty()) {
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }
}
