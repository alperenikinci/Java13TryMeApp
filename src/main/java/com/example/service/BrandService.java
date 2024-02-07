package com.example.service;

import com.example.config.ImgurUploader;
import com.example.dto.request.BrandSaveRequestDto;
import com.example.dto.request.ImageSaveRequestDto;
import com.example.entity.Brand;
import com.example.entity.Image;
import com.example.repository.BrandRepository;
import com.example.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public Brand saveBrand(BrandSaveRequestDto dto){
        Optional<Brand> brandOptional = brandRepository.findByBrandName(dto.getBrandName());
        if(brandOptional.isPresent()){
            return brandOptional.get();
        }
        return brandRepository.save(Brand.builder().brandName(dto.getBrandName()).build());
    }

}
