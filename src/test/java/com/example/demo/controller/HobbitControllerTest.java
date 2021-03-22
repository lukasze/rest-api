package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("prod")
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("GET /hobbits -> HTTP 200, all hobbits from DB")
    @Test
    @DirtiesContext
    void givenFullSpringContextAnd2HobbitsInDB_whenGETHobbits_shouldReturn200And2Hobbits() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hobbits"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String hobbitsInJSONFormat = mvcResult.getResponse().getContentAsString();
        List<Hobbit> allHobbitsInDb = objectMapper.readValue(hobbitsInJSONFormat, new TypeReference<>() {});

        assertAll(
                () -> assertEquals(2, allHobbitsInDb.size()),
                () -> assertEquals("Frodo", allHobbitsInDb.get(0).getName()),
                () -> assertEquals("Nowak", allHobbitsInDb.get(0).getLastName()),
                () -> assertEquals("Bilbo", allHobbitsInDb.get(1).getName()),
                () -> assertEquals("Baggins", allHobbitsInDb.get(1).getLastName())
        );
    }

    @DisplayName("POST /hobbits {new_hobbit} -> HTTP 200, created Hobbit from DB")
    @Test
    @DirtiesContext
    void whenPOSTHobbits_shouldReturn200AndNewHobbit() throws Exception {

        var hobbitName = "Bilbo";
        var hobbitLastName = "Tuk";
        Hobbit hobbitToSave = new Hobbit(null, hobbitName,hobbitLastName);
        String hobbitInJSONFormat = objectMapper.writeValueAsString(hobbitToSave);

        MvcResult mvcResult = mockMvc.perform(
                put("/hobbits")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(hobbitInJSONFormat)
                )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

        String hobbitsInJSONFormat = mvcResult.getResponse().getContentAsString();
        Hobbit createdHobbitFromDb = objectMapper.readValue(hobbitsInJSONFormat, Hobbit.class);

        assertAll(
                ()->assertEquals(hobbitName, createdHobbitFromDb.getName()),
                ()->assertEquals(hobbitLastName, createdHobbitFromDb.getLastName())
        );
    }
}