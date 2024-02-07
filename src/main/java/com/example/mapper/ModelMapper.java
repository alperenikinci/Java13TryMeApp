package com.example.mapper;

import com.example.dto.request.ModelSaveRequestDto;
import com.example.dto.request.ProductSaveRequestDto;
import com.example.dto.request.PropertySaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    ModelSaveRequestDto fromProductDtoToModelDto(final ProductSaveRequestDto dto);
}
