package com.example.demo.service;

import com.example.demo.model.Hobbit;
import com.example.demo.repository.HobbitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    public List<Hobbit> findAll(){
        return hobbitRepository.findAll();
    }

    public Hobbit save(Hobbit hobbit) {
        return hobbitRepository.save(hobbit);
    }
}
