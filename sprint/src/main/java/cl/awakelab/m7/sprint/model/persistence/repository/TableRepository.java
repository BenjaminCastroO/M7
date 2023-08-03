package cl.awakelab.m7.sprint.model.persistence.repository;

import cl.awakelab.m7.sprint.model.persistence.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Integer> {
  boolean existsById(int id);
}
