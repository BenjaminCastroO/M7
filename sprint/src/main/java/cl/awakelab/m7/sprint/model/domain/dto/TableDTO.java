package cl.awakelab.m7.sprint.model.domain.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TableDTO {
private int id;
private int number;
private int capacity;
private String location;
}
