package cl.awakelab.m7.sprint.model.persistence.repository;

import cl.awakelab.m7.sprint.model.persistence.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Integer> {
  boolean existsById(int id);
}
