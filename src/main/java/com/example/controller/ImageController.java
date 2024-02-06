package com.example.controller;

import com.example.dto.request.ImageSaveRequestDto;
import com.example.entity.Image;
import com.example.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.example.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(IMAGE)
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private Image saveImage(@RequestBody @ModelAttribute ImageSaveRequestDto dto){
        return imageService.saveImage(dto);
    }
}
