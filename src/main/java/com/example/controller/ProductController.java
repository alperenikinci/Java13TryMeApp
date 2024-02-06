package com.example.controller;

import com.example.dto.request.ProductSaveRequestDto;
import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product saveProduct(@RequestBody @ModelAttribute ProductSaveRequestDto dto){
        return productService.saveProduct(dto);
    }
}
