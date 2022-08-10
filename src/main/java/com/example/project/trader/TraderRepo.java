package com.example.project.trader;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TraderRepo extends CrudRepository<Trader, Long> {
    List<Trader> findAll();
}
