package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 3 sposoby, na dokumentację testu - komentarza, nazwa metody, @DisplayName
    @Test
    @DisplayName("GET /hobbits -> HTTP 200")
    void givenFullSpringContext_whenGETHobbits_shouldReturn200() throws Exception {
        // given full context with db (@SpringBootTest)

        // when GET http://localhost:8080/hobbits
                                                    // wywołanie endpoint'u (bez Tomcat'a)
        mockMvc.perform(get("/hobbits"))
                                                    // lepsze logowanie
                .andDo(print())
        // then should return HTTP 200
                                                    // czego oczekujemy od zwróconego komunikatu
                .andExpect(status().isOk());


    }
}