package com.example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Configuration
public class ImgurUploader {
    private final String API_BASE_URL = "https://api.imgur.com/3/image";


    @Value("${imgur.client.id}")
    private String clientId;
          //  = System.getenv("Java13_TryMeAppImgurClient");



    public String upload(MultipartFile image){

        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(API_BASE_URL);
            request.setHeader("Authorization", "Client-ID "+clientId);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("image",image.getInputStream(), ContentType.MULTIPART_FORM_DATA,image.getOriginalFilename());

            request.setEntity(builder.build());

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if( statusCode == 200){
                HttpEntity entity = response.getEntity();
                String jsonStr = EntityUtils.toString(entity);
                ObjectMapper objectMapper = new ObjectMapper();

                Map<String,Object> responseJsonMap = objectMapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {});
                Map<String, Object> data = (Map<String, Object>) responseJsonMap.get("data");
                String imageUrl = (String) data.get("link");
                return imageUrl;
            } else{
                //TODO Exception fırlatmak lazım.
                System.out.println(statusCode);
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
