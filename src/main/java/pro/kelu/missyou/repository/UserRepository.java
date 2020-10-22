package pro.kelu.missyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByOpenid(String openid);
}
