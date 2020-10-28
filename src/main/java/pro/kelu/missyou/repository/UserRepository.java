package pro.kelu.missyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByOpenid(String openid);
}
