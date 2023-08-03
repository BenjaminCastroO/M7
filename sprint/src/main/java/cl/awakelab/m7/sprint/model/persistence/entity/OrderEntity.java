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
@Table(name = "Pedido")
public class OrderEntity {
  @Id
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
