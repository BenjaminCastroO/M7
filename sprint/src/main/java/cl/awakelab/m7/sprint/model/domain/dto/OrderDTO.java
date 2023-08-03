package cl.awakelab.m7.sprint.model.domain.dto;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
private int id;
private TableDTO table;
private WaiterDTO waiter;
private Date date;
private Double total;
}
