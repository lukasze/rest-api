package com.example.demo.service;

import com.example.demo.model.Hobbit;
import com.example.demo.repository.HobbitRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
public class HobbitServiceImpl1 implements HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitServiceImpl1(HobbitRepository hobbitRepository) {
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
