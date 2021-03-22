package com.example.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 3 sposoby, na dokumentację testu - komentarza, nazwa metody, @DisplayName
    @Test
    @DisplayName("GET /hobbits -> HTTP 200")
    void givenFullSpringContext_whenGETHobbits_shouldReturn200() {
        // given full context with db (@SpringBootTest)

        // when GET http://localhost:8080/hobbits

        // then should return HTTP 200
        fail();
    }
}