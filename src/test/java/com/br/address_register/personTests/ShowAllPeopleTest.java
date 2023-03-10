package com.br.address_register.personTests;

import com.br.address_register.model.Person;
import com.br.address_register.repository.PersonRepository;
import com.br.address_register.utils.CreatePerson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.time.format.DateTimeFormatter;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShowAllPeopleTest {

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
    @DisplayName("1 - Should return a list of all registered people")
    void listAllPeople() throws Exception {
        Person firstPerson = CreatePerson.createTestPerson();
        Person secondPerson = CreatePerson.createSecondTestPerson();
        personRepository.save(firstPerson);
        personRepository.save(secondPerson);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String firstDate = firstPerson.getBirthDate().format(formatter);
        String secondDate = secondPerson.getBirthDate().format(formatter);
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(firstPerson.getName()))
                .andExpect(jsonPath("$[0].birthDate").value(firstDate))
                .andExpect(jsonPath("$[0].birthplace").value(firstPerson.getBirthplace()))
                .andExpect(jsonPath("$[0].birthState").value(firstPerson.getBirthState()))
                .andExpect(jsonPath("$[0].nationality").value(firstPerson.getNationality()))
                .andExpect(jsonPath("$[1].name").value(secondPerson.getName()))
                .andExpect(jsonPath("$[1].birthDate").value(secondDate))
                .andExpect(jsonPath("$[1].birthplace").value(secondPerson.getBirthplace()))
                .andExpect(jsonPath("$[1].birthState").value(secondPerson.getBirthState()))
                .andExpect(jsonPath("$[1].nationality").value(secondPerson.getNationality()));
    }
}
