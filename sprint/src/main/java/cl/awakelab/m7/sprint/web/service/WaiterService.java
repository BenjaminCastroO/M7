package cl.awakelab.m7.sprint.web.service;

import cl.awakelab.m7.sprint.model.domain.dto.WaiterDTO;

import java.util.List;
import java.util.Optional;

public interface WaiterService {
  Optional<List<WaiterDTO>> findAll();
  Optional<WaiterDTO> findById(int id);
  Optional<WaiterDTO> create(WaiterDTO waiterDTO);
  Optional<WaiterDTO> update(WaiterDTO waiterDTO);
}