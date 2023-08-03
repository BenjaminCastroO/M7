package cl.awakelab.m7.sprint.model.domain.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DishDTO {
private int id;
private String name;
private String description;
private Double price;
private String category;
}
