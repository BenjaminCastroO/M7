package cl.awakelab.m7.sprint.model.persistence.mapper;

import cl.awakelab.m7.sprint.model.domain.dto.DishDTO;
import cl.awakelab.m7.sprint.model.persistence.entity.DishEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="name", target ="name"),
          @Mapping(source ="description", target ="description"),
          @Mapping(source ="price", target ="price"),
          @Mapping(source ="category", target ="category"),
  })
  DishDTO toDishDTO(DishEntity dishEntity);
  List<DishDTO> toDishDTO(List<DishEntity> dishEntities);
  @InheritInverseConfiguration
  DishEntity toDishEntity(DishDTO dishDTO);
}
