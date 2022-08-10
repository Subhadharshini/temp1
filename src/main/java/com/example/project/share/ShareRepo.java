package com.example.project.share;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShareRepo extends CrudRepository<Share, Long> {
    List<Share> findAll();
}