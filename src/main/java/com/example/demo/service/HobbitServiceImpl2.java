package com.example.demo.service;

import com.example.demo.model.Hobbit;
import com.example.demo.repository.HobbitRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class HobbitServiceImpl2 implements HobbitService {
    private HobbitRepository hobbitRepository;

    public HobbitServiceImpl2(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    @Override
    public List<Hobbit> findAll(){
        return hobbitRepository.findAll();
    }

    @Override
    public Hobbit save(Hobbit hobbit) {
        return hobbitRepository.save(hobbit);
    }
}
