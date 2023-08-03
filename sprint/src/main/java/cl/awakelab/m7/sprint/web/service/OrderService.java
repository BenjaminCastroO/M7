package cl.awakelab.m7.sprint.web.service;

import cl.awakelab.m7.sprint.model.domain.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
  Optional<List<OrderDTO>> findAll();
  Optional<OrderDTO> findById(int id);
  Optional<OrderDTO> create(OrderDTO orderDTO);
  Optional<OrderDTO> update(OrderDTO orderDTO);
}