package pro.kelu.missyou.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String openid;
    private String nickname;
    private Long unifyUid;
    private String email;
    private String password;
    private String mobile;
//    private String wxProfile;


}
