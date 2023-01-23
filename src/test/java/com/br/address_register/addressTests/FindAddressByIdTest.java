package com.br.address_register.addressTests;

import com.br.address_register.model.Address;
import com.br.address_register.model.Person;
import com.br.address_register.repository.AddressRepository;
import com.br.address_register.repository.PersonRepository;
import com.br.address_register.utils.CreateAddress;
import com.br.address_register.utils.CreatePerson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindAddressByIdTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @BeforeEach
    public void setup() {
        personRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        personRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("1 - Must find address by id successfully")
    public void findAddressByIdSuccessfully() throws Exception {
        Person person = CreatePerson.createTestPerson();
        Address address = CreateAddress.createTestAddress();
        person.addAddress(address);
        personRepository.save(person);
        mockMvc.perform(get("/address/" + address.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(address)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    @DisplayName("2 - Should throw a error when the id is not found")
    void idNotFoundWhenLookingAddress() throws Exception {
        mockMvc.perform(get("/address/" + 10552L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
