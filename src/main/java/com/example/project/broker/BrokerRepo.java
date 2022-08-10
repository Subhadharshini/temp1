package com.example.project.broker;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrokerRepo extends CrudRepository<Broker, Long> {
    List<Broker> findAll();
}