package cl.awakelab.m7.sprint.model.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "mesa")
public class TableEntity {
  @Id
  @Column(name="Id")
  private int id;
  @Column(name="Numero")
  private int numero;
  @Column(name="Capacidad")
  private int capacidad;
  @Column(name="Ubicacion")
  private String ubicacion;
}
