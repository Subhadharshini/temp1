package com.example.project.property;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long> {
    List<Property> findAll();
    Property findByid(Long id);
}