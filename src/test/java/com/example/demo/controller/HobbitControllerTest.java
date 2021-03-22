package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.model.Hobbit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

//    @DisplayName("GET /hobbits -> HTTP 200, all hobbits from DB")
    @Test
    void givenFullSpringContextAnd2HobbitsInDB_whenGETHobbits_shouldReturn200And2Hobbits() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hobbits"))
                .andDo(print())
                .andExpect(status().isOk())
//       1 pobranie danych z odpowiedzi
                .andReturn();
        String hobbitsInJSONFormat = mvcResult.getResponse().getContentAsString();

//       2 zmapowanie JSON'a do postaci obiektowej
        List<Hobbit> allHobbitsinDb = objectMapper.readValue(hobbitsInJSONFormat, new TypeReference<>() {});

//       3 asercje sprawdzające zwrócone dane zmapowane do postaci obiektowej
        assertAll(
                () -> assertEquals(2, allHobbitsinDb.size()),
                () -> assertEquals("Frodo", allHobbitsinDb.get(0).getName()),
                () -> assertEquals("Nowak", allHobbitsinDb.get(0).getLastName()),
                () -> assertEquals("Bilbo", allHobbitsinDb.get(1).getName()),
                () -> assertEquals("Baggins", allHobbitsinDb.get(1).getLastName())
        );
    }
}