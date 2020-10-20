package pro.kelu.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
//@Where("delete_time is null and online = 1")
public abstract class BaseEntity {
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    private Date deleteTime;
}
