package com.example.project.bonds;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BondRepo extends CrudRepository<Bond, Long> {

    List<Bond> findAll();


}