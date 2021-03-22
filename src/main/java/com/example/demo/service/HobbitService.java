package com.example.demo.service;

import com.example.demo.model.Hobbit;

import java.util.List;

public interface HobbitService {
    List<Hobbit> findAll();

    Hobbit save(Hobbit hobbit);
}
