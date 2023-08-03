package cl.awakelab.m7.sprint.model.persistence.mapper;

import cl.awakelab.m7.sprint.model.domain.dto.WaiterDTO;
import cl.awakelab.m7.sprint.model.persistence.entity.WaiterEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WaiterMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="name", target ="name"),
          @Mapping(source ="age", target ="age"),
          @Mapping(source ="startDate", target ="startDate"),
  })
  WaiterDTO toWaiterDTO(WaiterEntity waiterEntity);
  List<WaiterDTO> toWaiterDTO(List<WaiterEntity> waiterEntities);
  @InheritInverseConfiguration
  WaiterEntity toWaiterEntity(WaiterDTO waiterDTO);
}
