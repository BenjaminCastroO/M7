package cl.awakelab.m7.sprint.web.controller;

import cl.awakelab.m7.sprint.model.domain.dto.WaiterDTO;
import cl.awakelab.m7.sprint.web.service.WaiterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camarero")
public class WaiterRestController {
  private final WaiterService service;

  public WaiterRestController(WaiterService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<WaiterDTO>> findAll() {
    return service.findAll().map(waiterDTO -> new ResponseEntity<>(waiterDTO, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<WaiterDTO> create(@RequestBody WaiterDTO waiterDTO){
    return service.create(waiterDTO)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<WaiterDTO> update(@RequestBody WaiterDTO waiterDTO){
    return service.update(waiterDTO)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
