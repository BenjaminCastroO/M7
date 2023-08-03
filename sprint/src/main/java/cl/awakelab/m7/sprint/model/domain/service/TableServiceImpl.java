package cl.awakelab.m7.sprint.model.domain.service;

import cl.awakelab.m7.sprint.model.domain.dto.TableDTO;
import cl.awakelab.m7.sprint.model.persistence.mapper.TableMapper;
import cl.awakelab.m7.sprint.model.persistence.repository.TableRepository;
import cl.awakelab.m7.sprint.web.service.TableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {

  private final TableRepository repository;
  private final TableMapper mapper;

  public TableServiceImpl(TableRepository repository, TableMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<TableDTO>> findAll() {
    return Optional.of(mapper.toTableDTO(repository.findAll()));
  }
  @Override
  public Optional<TableDTO> findById(int id) {
    return repository.findById(id).map(mapper::toTableDTO);
  }
  @Override
  public Optional<TableDTO> create(TableDTO tableDTO){
    return Optional.of(mapper.toTableDTO(repository.save(mapper.toTableEntity(tableDTO))));
  }
  @Override
  public Optional<TableDTO> update(TableDTO tableDTO) {
    if (repository.existsById(tableDTO.getId())){
      return Optional.of(mapper.toTableDTO(repository.save(mapper.toTableEntity(tableDTO))));
    }
    return Optional.of(new TableDTO());
  }
}

