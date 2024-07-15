package az.atl.academy.customerspringproject.mapper;

import az.atl.academy.customerspringproject.dao.entity.CustomerEntity;
import az.atl.academy.customerspringproject.model.CustomerDto;
import az.atl.academy.customerspringproject.model.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CustomerMapper {
    CustomerEntity toEntity(CustomerRequest customerRequest);

    CustomerDto toDto(CustomerEntity customerEntity);
}
