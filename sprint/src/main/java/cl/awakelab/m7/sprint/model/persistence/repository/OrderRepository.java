package cl.awakelab.m7.sprint.model.persistence.repository;

import cl.awakelab.m7.sprint.model.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
  boolean existsById(int id);
}
