package pro.kelu.missyou.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import pro.kelu.missyou.model.Category;

@Getter
@Setter
public class CategoryPureVO {
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;
    private short online;
    private Long level;

    public CategoryPureVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }
}
