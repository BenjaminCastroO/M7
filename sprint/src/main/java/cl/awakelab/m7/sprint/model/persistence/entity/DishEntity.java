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
@Table(name = "Plato")
public class DishEntity {
  @Id
  @Column(name="ID")
  private int id;
  @Column(name="Nombre")
  private String nombre;
  @Column(name="Descripcion")
  private String descripcion;
  @Column(name="Precio")
  private Double precio;
  @Column(name="Categoria")
  private String categoria;
}
