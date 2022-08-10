package com.example.project.stock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends CrudRepository<Stock, Long> {

    List<Stock> findAll();

}