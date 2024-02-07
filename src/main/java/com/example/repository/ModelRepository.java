package com.example.repository;

import com.example.entity.Image;
import com.example.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

    Optional<Model> findByModelName(String modelName);
}
