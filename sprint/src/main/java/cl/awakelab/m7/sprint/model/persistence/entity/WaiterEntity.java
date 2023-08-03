package cl.awakelab.m7.sprint.model.persistence.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Camarero")
public class WaiterEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="Id")
  private int id;
  @Column(name="Nombre")
  private String name;
  @Column(name="Edad")
  private int age;
  @Column(name="Fecha_Inicio")
  private Date startDate;
}
