package cl.awakelab.m7.sprint.model.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Camarero")
public class WaiterEntity {
  @Id
  @Column(name="Id")
  private int id;
  @Column(name="Nombre")
  private String name;
  @Column(name="Edad")
  private int age;
  @Column(name="Fecha_Inicio")
  private Date startDate;
}
