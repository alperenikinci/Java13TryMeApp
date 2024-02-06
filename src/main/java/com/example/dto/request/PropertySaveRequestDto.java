package com.example.dto.request;

import com.example.utility.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertySaveRequestDto {

    private ECategory category;
    private ESubCategory subCategory;
    private EColor color;
    private ESize size;
    private EGender gender;
}
