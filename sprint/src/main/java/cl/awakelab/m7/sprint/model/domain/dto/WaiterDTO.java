package cl.awakelab.m7.sprint.model.domain.dto;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WaiterDTO {
private int id;
private String name;
private int age;
private Date startDate;
}
