package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.example.demo.service.HobbitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HobbitController {

    private final HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    @GetMapping("/hobbits")
    public List<Hobbit> findAll(){
        return hobbitService.findAll();
    }

    @PutMapping("/hobbits")
    public Hobbit save(@RequestBody Hobbit hobbit) {
        return hobbitService.save(hobbit);
    }
}
