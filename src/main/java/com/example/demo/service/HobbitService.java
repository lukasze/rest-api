package com.example.demo.service;

import com.example.demo.model.Hobbit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbitService {
    public List<Hobbit> findAll(){
        return List.of(
                new Hobbit(1L, "Frodo", "Baggins"),
                new Hobbit(2L, "Bilbo", "Baggins"),
                new Hobbit(3L, "Penelope", "Tuk")
        );
    }
}
