package cl.awakelab.m7.sprint.model.persistence.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Plato")
public class DishEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="Id")
  private int id;
  @Column(name="Nombre")
  private String name;
  @Column(name="Descripcion")
  private String description;
  @Column(name="Precio")
  private Double price;
  @Column(name="Categoria")
  private String category;
}
