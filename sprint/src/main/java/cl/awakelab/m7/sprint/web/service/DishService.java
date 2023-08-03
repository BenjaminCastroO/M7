package cl.awakelab.m7.sprint.web.service;

import cl.awakelab.m7.sprint.model.domain.dto.DishDTO;
import java.util.List;
import java.util.Optional;

public interface DishService {
  Optional<List<DishDTO>> findAll();
  Optional<DishDTO> findById(int id);
  Optional<DishDTO> create(DishDTO dishDTO);
  Optional<DishDTO> update(DishDTO dishDTO);
}