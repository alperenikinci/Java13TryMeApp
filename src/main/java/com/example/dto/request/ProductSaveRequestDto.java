package com.example.dto.request;

import com.example.utility.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSaveRequestDto {
    private String brandName;
    private String modelName;
    private String productName;
    private Long quantity;
    private Double price;
    private ECategory category;
    private ESubCategory subCategory;
    private EColor color;
    private ESize size;
    private EGender gender;
    private List<MultipartFile> images;


}
