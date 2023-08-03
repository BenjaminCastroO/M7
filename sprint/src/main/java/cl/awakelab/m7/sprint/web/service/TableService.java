package cl.awakelab.m7.sprint.web.service;

import cl.awakelab.m7.sprint.model.domain.dto.TableDTO;

import java.util.List;
import java.util.Optional;

public interface TableService {
  Optional<List<TableDTO>> findAll();
  Optional<TableDTO> findById(int id);
  Optional<TableDTO> create(TableDTO tableDTO);
  Optional<TableDTO> update(TableDTO tableDTO);
}