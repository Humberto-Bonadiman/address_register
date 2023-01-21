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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EditPersonTest {

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
    @DisplayName("1 - Must edit a person successfully")
    void editPersonSuccessfully() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        PersonTestDto personTestDto = CreatePerson.createPersonTestDto();
        mockMvc.perform(put("/person/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(personTestDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    @DisplayName("2 - Should throw a error when the id is not found")
    void idNotFoundWhenEditingPerson() throws Exception {
        PersonTestDto personTestDto = CreatePerson.createPersonTestDto();
        mockMvc.perform(put("/person/" + 10552)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(personTestDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(3)
    @DisplayName("3 - Must throw a error without the birth date")
    void badRequestWithoutBirthDate() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        PersonTestDto errorPerson = new PersonTestDto();
        errorPerson.setName("Bad Request");
        // errorPerson.setBirthDate("20/05/1994");
        errorPerson.setBirthplace("Bad Request");
        errorPerson.setBirthState("Bad Request");
        errorPerson.setNationality("Bad Request");
        mockMvc.perform(put("/person/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(errorPerson)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(4)
    @DisplayName("4 - Must throw a error without the name")
    void badRequestWithoutName() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        PersonTestDto errorPerson = new PersonTestDto();
        // errorPerson.setName("Bad Request");
        errorPerson.setBirthDate("20/05/1994");
        errorPerson.setBirthplace("Bad Request");
        errorPerson.setBirthState("Bad Request");
        errorPerson.setNationality("Bad Request");
        mockMvc.perform(put("/person/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(errorPerson)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(5)
    @DisplayName("5 - Must throw a error without the birthplace")
    void badRequestWithoutBirthplace() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        PersonTestDto errorPerson = new PersonTestDto();
        errorPerson.setName("Bad Request");
        errorPerson.setBirthDate("20/05/1994");
        // errorPerson.setBirthplace("Bad Request");
        errorPerson.setBirthState("Bad Request");
        errorPerson.setNationality("Bad Request");
        mockMvc.perform(put("/person/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(errorPerson)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(6)
    @DisplayName("6 - Must throw a error without the birth state")
    void badRequestWithoutBirthState() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        PersonTestDto errorPerson = new PersonTestDto();
        errorPerson.setName("Bad Request");
        errorPerson.setBirthDate("20/05/1994");
        errorPerson.setBirthplace("Bad Request");
        // errorPerson.setBirthState("Bad Request");
        errorPerson.setNationality("Bad Request");
        mockMvc.perform(put("/person/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(errorPerson)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(7)
    @DisplayName("7 - Must throw a error without the nationality")
    void badRequestWithoutNationality() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        PersonTestDto errorPerson = new PersonTestDto();
        errorPerson.setName("Bad Request");
        errorPerson.setBirthDate("20/05/1994");
        errorPerson.setBirthplace("Bad Request");
        errorPerson.setBirthState("Bad Request");
        // errorPerson.setNationality("Bad Request");
        mockMvc.perform(put("/person/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(errorPerson)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
