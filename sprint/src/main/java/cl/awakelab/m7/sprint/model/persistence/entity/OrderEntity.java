package cl.awakelab.m7.sprint.model.persistence.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Pedido")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="Id")
  private int id;
  @ManyToOne
  @JoinColumn(name = "Mesa_Id", insertable = true, updatable = false)
  private TableEntity table;
  @ManyToOne
  @JoinColumn(name = "Camarero_Id", insertable = true, updatable = false)
  private WaiterEntity  waiter;
  @Column(name="Fecha")
  private Date date;
  @Column(name="Total")
  private Double total;
}
