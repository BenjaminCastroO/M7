package cl.awakelab.m7.sprint.model.persistence.repository;

import cl.awakelab.m7.sprint.model.persistence.entity.WaiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterRepository extends JpaRepository<WaiterEntity, Integer> {
  boolean existsById(int id);
}
