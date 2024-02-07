package com.example.repository;

import com.example.entity.Image;
import com.example.entity.Property;
import com.example.utility.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {

    Optional<Property> findByCategoryAndSubCategoryAndGenderAndColorAndSize(
            ECategory category,
            ESubCategory subCategory,
            EGender gender,
            EColor color,
            ESize size);
}
