package top.fan2wan.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.fan2wan.order.entity.OrderEntity;

/**
 * @description: test for Jpa repository
 * @author: FantTao
 * @date: 2020-02-15 13:35
 */
@Repository
public interface TestRepository extends JpaRepository<OrderEntity,Long> {
}
