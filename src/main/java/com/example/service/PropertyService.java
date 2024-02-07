package com.example.service;

import com.example.dto.request.PropertySaveRequestDto;
import com.example.entity.Property;
import com.example.mapper.PropertyMapper;
import com.example.repository.BrandRepository;
import com.example.repository.PropertyRepository;
import com.example.utility.enums.ECategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public Property saveProperty(PropertySaveRequestDto dto){
        Optional<Property> propertyOptional = propertyRepository.findByCategoryAndSubCategoryAndGenderAndColorAndSize(
                dto.getCategory(),
                dto.getSubCategory(),
                dto.getGender(),
                dto.getColor(),
                dto.getSize());
        if(propertyOptional.isPresent()){
            return propertyOptional.get();
        }
        Property property = PropertyMapper.INSTANCE.fromPropertySaveRequestDtoToProperty(dto);
        if(propertyCategoryMismatchChecker(dto)){
            return propertyRepository.save(property);
        } else {
            //TODO hata fırlatılacak.
            throw new RuntimeException();
        }
    }

    public Boolean propertyCategoryMismatchChecker(PropertySaveRequestDto dto){
        ECategory dtoCategory = dto.getCategory();
        ECategory dtoSubCategoryCategory = dto.getSubCategory().getCategory();
        return dtoCategory.equals(dtoSubCategoryCategory);
    }

}
