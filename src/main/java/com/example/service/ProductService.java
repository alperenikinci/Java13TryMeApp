package com.example.service;

import com.example.dto.request.*;
import com.example.entity.*;
import com.example.mapper.BrandMapper;
import com.example.mapper.ModelMapper;
import com.example.mapper.PropertyMapper;
import com.example.repository.BrandRepository;
import com.example.repository.ProductRepository;
import com.example.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final PropertyService propertyService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final ImageService imageService;

    public Product saveProduct(ProductSaveRequestDto dto){

        Brand brand = brandService.saveBrand(BrandMapper.INSTANCE.fromProductDtoToBrandDto(dto));
        ModelSaveRequestDto modelDto = ModelMapper.INSTANCE.fromProductDtoToModelDto(dto);
        modelDto.setBrandId(brand.getId());
        Model model = modelService.saveModel(modelDto);
        Property property = propertyService.saveProperty(PropertyMapper.INSTANCE.fromProductDtoToPropertyDto(dto));
        Image image = imageService.saveImage(ImageSaveRequestDto.builder().images(dto.getImages()).build());
        Product product = productRepository.save(Product
                .builder()
                        .productName(dto.getProductName())
                        .price(dto.getPrice())
                        .quantity(dto.getQuantity())
                        .modelId(model.getId())
                        .imageId(image.getId())
                        .propertyId(property.getId())
                .build());
        return product;
    }

}
