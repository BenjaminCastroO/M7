package cl.awakelab.m7.sprint.web.controller;

import cl.awakelab.m7.sprint.model.domain.dto.TableDTO;
import cl.awakelab.m7.sprint.web.service.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesa")
public class TableRestController {
  private final TableService service;

  public TableRestController(TableService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<TableDTO>> findAll() {
    return service.findAll().map(waiterDTO -> new ResponseEntity<>(waiterDTO, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<TableDTO> create(@RequestBody TableDTO waiterDTO){
    return service.create(waiterDTO)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<TableDTO> update(@RequestBody TableDTO tableDTO){
    return service.update(tableDTO)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
