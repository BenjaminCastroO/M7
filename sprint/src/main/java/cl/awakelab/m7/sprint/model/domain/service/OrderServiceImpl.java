package cl.awakelab.m7.sprint.model.domain.service;

import cl.awakelab.m7.sprint.model.domain.dto.OrderDTO;
import cl.awakelab.m7.sprint.model.persistence.mapper.OrderMapper;
import cl.awakelab.m7.sprint.model.persistence.repository.OrderRepository;
import cl.awakelab.m7.sprint.web.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository repository;
  private final OrderMapper mapper;

  public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<OrderDTO>> findAll() {
    return Optional.of(mapper.toOrderDTO(repository.findAll()));
  }
  @Override
  public Optional<OrderDTO> findById(int id) {
    return repository.findById(id).map(mapper::toOrderDTO);
  }
  @Override
  public Optional<OrderDTO> create(OrderDTO orderDTO){
    return Optional.of(mapper.toOrderDTO(repository.save(mapper.toOrderEntity(orderDTO))));
  }
  @Override
  public Optional<OrderDTO> update(OrderDTO orderDTO) {
    if (repository.existsById(orderDTO.getId())){
      return Optional.of(mapper.toOrderDTO(repository.save(mapper.toOrderEntity(orderDTO))));
    }
    return Optional.of(new OrderDTO());
  }
}

