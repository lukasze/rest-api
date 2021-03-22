package com.example.demo.repository;

import com.example.demo.model.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbitRepository extends JpaRepository<Hobbit, Long> {
}
