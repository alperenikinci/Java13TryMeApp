package com.example.service;

import com.example.dto.request.ModelSaveRequestDto;
import com.example.entity.Model;
import com.example.repository.BrandRepository;
import com.example.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;

    public Model saveModel(ModelSaveRequestDto dto){
        Model model = Model.builder()
                .modelName(dto.getModelName())
                .brandId(dto.getBrandId())
                .build();
        return modelRepository.save(model);
    }

}
