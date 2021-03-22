package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HobbitController {

    @GetMapping("/hobbits")
    public List<Hobbit> findAll(){
        return List.of(
                new Hobbit(1L, "Frodo", "Baggins"),
                new Hobbit(2L, "Bilbo", "Baggins"),
                new Hobbit(3L, "Penelope", "Tuk")
        );
    }
}
