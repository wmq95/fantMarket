package top.fan2wan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.fan2wan.user.entity.UserEntity;

/**
 * @description: repository for user
 * @author: FantTao
 * @date: 2020-02-24 9:33
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
