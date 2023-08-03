package cl.awakelab.m7.sprint.model.persistence.mapper;

import cl.awakelab.m7.sprint.model.domain.dto.OrderDTO;
import cl.awakelab.m7.sprint.model.persistence.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {TableMapper.class,
        WaiterMapper.class})
public interface OrderMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="table", target ="table"),
          @Mapping(source ="waiter", target ="waiter"),
          @Mapping(source ="date", target ="date"),
          @Mapping(source ="total", target ="total")
  })
  OrderDTO toOrderDTO(OrderEntity orderEntity);
  List<OrderDTO> toOrderDTO(List<OrderEntity> orderEntities);
  @InheritInverseConfiguration
  OrderEntity toOrderEntity(OrderDTO orderDTO);
}
