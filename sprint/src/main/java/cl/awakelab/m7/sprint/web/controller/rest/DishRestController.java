package cl.awakelab.m7.sprint.web.controller.rest;

import cl.awakelab.m7.sprint.model.domain.dto.DishDTO;
import cl.awakelab.m7.sprint.web.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plato")
public class DishRestController {
  private final DishService service;

  public DishRestController(DishService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<DishDTO>> findAll() {
    return service.findAll().map(waiterDTO -> new ResponseEntity<>(waiterDTO, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<DishDTO> create(@RequestBody DishDTO waiterDTO){
    return service.create(waiterDTO)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<DishDTO> update(@RequestBody DishDTO dishDTO){
    return service.update(dishDTO)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
