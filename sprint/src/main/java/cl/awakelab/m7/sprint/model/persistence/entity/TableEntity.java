package cl.awakelab.m7.sprint.model.persistence.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Mesa")
public class TableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="Id")
  private int id;
  @Column(name="Numero")
  private int number;
  @Column(name="Capacidad")
  private int capacity;
  @Column(name="Ubicacion")
  private String location;
}
