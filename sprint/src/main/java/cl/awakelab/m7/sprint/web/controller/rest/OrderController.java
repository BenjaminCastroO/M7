package cl.awakelab.m7.sprint.web.controller.rest;

import cl.awakelab.m7.sprint.model.domain.dto.DishDTO;
import cl.awakelab.m7.sprint.model.domain.dto.OrderDTO;
import cl.awakelab.m7.sprint.web.service.DishService;
import cl.awakelab.m7.sprint.web.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedido")
public class OrderController {
  private final OrderService service;
  private final OrderRestController orderRestController;


  public OrderController(OrderService service,
                         OrderRestController orderRestController) {
    this.service = service;
    this.orderRestController = orderRestController;
  }

  @GetMapping
  public String listOrder(Model model){
    List<OrderDTO> orderList = orderRestController.findAll().getBody();
    model.addAttribute("orderList", orderList);
    return "listOrder";
  }
  @GetMapping ("/c")
  public String createOrder(Model model){
    String op = "c";
    model.addAttribute("op",op);
    return "order";
  }

  @PostMapping("/c")
  public String create(@ModelAttribute OrderDTO order, HttpServletRequest request){
    orderRestController.create(order);
    return "redirect:/pedido";
  }
  @GetMapping("/u/{Id}")
  public String editOrder(@PathVariable int Id, Model model){
    model.addAttribute("order", service.findById(Id).get());
    model.addAttribute("op","u");
    return "order";
  }
  @PostMapping("/u")
  public String saveEditOrder(@ModelAttribute OrderDTO order, Model model){
    orderRestController.update(order);
    return "redirect:/pedido";
  }
}