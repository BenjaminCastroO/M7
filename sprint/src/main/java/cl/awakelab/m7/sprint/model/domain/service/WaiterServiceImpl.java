package cl.awakelab.m7.sprint.model.domain.service;

import cl.awakelab.m7.sprint.model.domain.dto.WaiterDTO;
import cl.awakelab.m7.sprint.model.persistence.mapper.WaiterMapper;
import cl.awakelab.m7.sprint.model.persistence.repository.WaiterRepository;
import cl.awakelab.m7.sprint.web.service.WaiterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaiterServiceImpl implements WaiterService {

  private final WaiterRepository repository;
  private final WaiterMapper mapper;

  public WaiterServiceImpl(WaiterRepository repository, WaiterMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<WaiterDTO>> findAll() {
    return Optional.of(mapper.toWaiterDTO(repository.findAll()));
  }
  @Override
  public Optional<WaiterDTO> findById(int id) {
    return repository.findById(id).map(mapper::toWaiterDTO);
  }
  @Override
  public Optional<WaiterDTO> create(WaiterDTO waiterDTO){
    return Optional.of(mapper.toWaiterDTO(repository.save(mapper.toWaiterEntity(waiterDTO))));
  }
  @Override
  public Optional<WaiterDTO> update(WaiterDTO waiterDTO) {
    if (repository.existsById(waiterDTO.getId())){
      return Optional.of(mapper.toWaiterDTO(repository.save(mapper.toWaiterEntity(waiterDTO))));
    }
    return Optional.of(new WaiterDTO());
  }
}

