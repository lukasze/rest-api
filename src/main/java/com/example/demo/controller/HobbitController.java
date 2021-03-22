package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.example.demo.service.HobbitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HobbitController {

    private final HobbitService hobbitService;
    // nie ma adnotacji @Autowired - jeśli mamy 1 konstruktor
    // nie potrzebujemy jej dodawać
    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    @GetMapping("/hobbits")
    public List<Hobbit> findAll(){
        return hobbitService.findAll();
    }
}
