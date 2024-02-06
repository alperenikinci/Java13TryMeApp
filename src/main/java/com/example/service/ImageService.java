package com.example.service;

import com.example.config.ImgurUploader;
import com.example.dto.request.ImageSaveRequestDto;
import com.example.entity.Image;
import com.example.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImgurUploader imgurUploader;

    public Image saveImage(ImageSaveRequestDto dto){
        List<String> imageUrls = new ArrayList<>();
        List<MultipartFile> images = dto.getImages();
        String imageUrl = null;
        if(images.size()>0 && images.size()<5 ){
            for (int i = 0; i<images.size();i++){
                imageUrl = imgurUploader.upload(images.get(i));
                imageUrls.add(imageUrl);
            }
        } else {
            //TODO TryMeAppException fırlatılacak.
            throw new RuntimeException("Fotograflar yuklenirken bir seyler yanlis gitti");
        }

        Image image = Image.builder()
                .mainImageUrl(imageUrls.get(0))
                .additionalImageUrls(imageUrls.subList(1, imageUrls.size()))
                .build();

        return imageRepository.save(image);
    }
}
