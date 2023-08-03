package cl.awakelab.m7.sprint.web.controller;

import cl.awakelab.m7.sprint.model.domain.dto.DishDTO;
import cl.awakelab.m7.sprint.web.controller.rest.DishRestController;
import cl.awakelab.m7.sprint.web.service.DishService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/plato")
public class DishController {
  private final DishService service;
  private final DishRestController dishRestController;


  public DishController(DishService service,
                        DishRestController dishRestController) {
    this.service = service;
    this.dishRestController = dishRestController;
  }

  @GetMapping
  public String listDish(Model model){
    List<DishDTO> dishList = dishRestController.findAll().getBody();
    model.addAttribute("dishList", dishList);
    return "listDish";
  }
  @GetMapping ("/c")
  public String createDish(Model model){
    String op = "c";
    model.addAttribute("op",op);
    return "dish";
  }

  @PostMapping("/c")
  public String create(@ModelAttribute DishDTO dish, HttpServletRequest request){
    dishRestController.create(dish);
    return "redirect:/plato";
  }
  @GetMapping("/u/{Id}")
  public String editDish(@PathVariable int Id, Model model){
    model.addAttribute("dish", service.findById(Id).get());
    model.addAttribute("op","u");
    return "dish";
  }
  @PostMapping("/u")
  public String saveEditDish(@ModelAttribute DishDTO dish, Model model){
    dishRestController.update(dish);
    return "redirect:/plato";
  }
}