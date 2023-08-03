package cl.awakelab.m7.sprint.model.persistence.mapper;

import cl.awakelab.m7.sprint.model.domain.dto.TableDTO;
import cl.awakelab.m7.sprint.model.persistence.entity.TableEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TableMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="numero", target ="number"),
          @Mapping(source ="capacidad", target ="capacity"),
          @Mapping(source ="ubicacion", target ="location")
  })
  TableDTO toTableDTO(TableEntity tableEntity);
  List<TableDTO> toTableDTO(List<TableEntity> tableEntities);
  @InheritInverseConfiguration
  TableEntity toTableEntity(TableDTO tableDTO);
}
