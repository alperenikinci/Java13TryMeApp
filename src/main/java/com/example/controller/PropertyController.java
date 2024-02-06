package com.example.controller;

import com.example.dto.request.PropertySaveRequestDto;
import com.example.entity.Property;
import com.example.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

//    @PostMapping("/save")
//    public Property saveProperty(PropertySaveRequestDto dto){
//        return propertyService.saveProperty(dto);
//    }
}
