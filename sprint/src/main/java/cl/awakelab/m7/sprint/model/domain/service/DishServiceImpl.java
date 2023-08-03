package cl.awakelab.m7.sprint.model.domain.service;

import cl.awakelab.m7.sprint.model.domain.dto.DishDTO;
import cl.awakelab.m7.sprint.model.persistence.mapper.DishMapper;
import cl.awakelab.m7.sprint.model.persistence.repository.DishRepository;
import cl.awakelab.m7.sprint.web.service.DishService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

  private final DishRepository repository;
  private final DishMapper mapper;

  public DishServiceImpl(DishRepository repository, DishMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<DishDTO>> findAll() {
    return Optional.of(mapper.toDishDTO(repository.findAll()));
  }
  @Override
  public Optional<DishDTO> findById(int id) {
    return repository.findById(id).map(mapper::toDishDTO);
  }
  @Override
  public Optional<DishDTO> create(DishDTO dishDTO){
    return Optional.of(mapper.toDishDTO(repository.save(mapper.toDishEntity(dishDTO))));
  }
  @Override
  public Optional<DishDTO> update(DishDTO dishDTO) {
    if (repository.existsById(dishDTO.getId())){
      return Optional.of(mapper.toDishDTO(repository.save(mapper.toDishEntity(dishDTO))));
    }
    return Optional.of(new DishDTO());
  }
}

