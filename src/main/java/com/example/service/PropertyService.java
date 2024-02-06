package com.example.service;

import com.example.dto.request.PropertySaveRequestDto;
import com.example.entity.Property;
import com.example.repository.BrandRepository;
import com.example.repository.PropertyRepository;
import com.example.utility.enums.ECategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public Property saveProperty(PropertySaveRequestDto dto){
        Property property = Property.builder()
                .category(dto.getCategory())
                .color(dto.getColor())
                .gender(dto.getGender())
                .size(dto.getSize())
                .subCategory(dto.getSubCategory())
                .build();
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
