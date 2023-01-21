package com.br.address_register.PersonTests;

import com.br.address_register.dto.PersonTestDto;
import com.br.address_register.model.Person;
import com.br.address_register.repository.PersonRepository;
import com.br.address_register.utils.CreatePerson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreatePersonTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void setup() {
        personRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        personRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("1 - Must register a person successfully")
    void createPersonSuccessfully() throws Exception {
        PersonTestDto person = CreatePerson.createPersonTestDto();
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    @DisplayName("2 - Must throw a error without the birth date")
    void badRequestWithoutBirthDate() throws Exception {
        PersonTestDto person = new PersonTestDto();
        person.setName("Bad Request");
        person.setBirthplace("Bad Request");
        person.setBirthState("Bad Request");
        person.setNationality("Bad Request");
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(3)
    @DisplayName("3 - Must throw a error without the name")
    void badRequestWithoutName() throws Exception {
        PersonTestDto person = new PersonTestDto();
        person.setBirthplace("Bad Request");
        person.setBirthState("Bad Request");
        person.setNationality("Bad Request");
        person.setBirthDate("20/05/1994");
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(4)
    @DisplayName("4 - Must throw a error without the birthplace")
    void badRequestWithoutBirthplace() throws Exception {
        PersonTestDto person = new PersonTestDto();
        person.setName("Bad Request");
        person.setBirthState("Bad Request");
        person.setNationality("Bad Request");
        person.setBirthDate("20/05/1994");
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(5)
    @DisplayName("5 - Must throw a error without the birth state")
    void badRequestWithoutBirthState() throws Exception {
        PersonTestDto person = new PersonTestDto();
        person.setName("Bad Request");
        person.setBirthplace("Bad Request");
        person.setNationality("Bad Request");
        person.setBirthDate("20/05/1994");
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(6)
    @DisplayName("6 - Must throw a error without the nationality")
    void badRequestWithoutNationality() throws Exception {
        PersonTestDto person = new PersonTestDto();
        person.setName("Bad Request");
        person.setBirthplace("Bad Request");
        person.setBirthState("Bad Request");
        person.setBirthDate("20/05/1994");
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
