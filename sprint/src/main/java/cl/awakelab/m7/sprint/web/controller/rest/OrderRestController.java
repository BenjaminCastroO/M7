package cl.awakelab.m7.sprint.web.controller.rest;

import cl.awakelab.m7.sprint.model.domain.dto.OrderDTO;
import cl.awakelab.m7.sprint.web.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class OrderRestController {
  private final OrderService service;

  public OrderRestController(OrderService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<OrderDTO>> findAll() {
    return service.findAll().map(waiterDTO -> new ResponseEntity<>(waiterDTO, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO waiterDTO){
    return service.create(waiterDTO)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO){
    return service.update(orderDTO)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
