package com.br.address_register.AddressTests;

import com.br.address_register.model.Address;
import com.br.address_register.model.Person;
import com.br.address_register.repository.AddressRepository;
import com.br.address_register.repository.PersonRepository;
import com.br.address_register.service.AddressService;
import com.br.address_register.utils.CreateAddress;
import com.br.address_register.utils.CreatePerson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RemovePersonFromAddressTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

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
    @DisplayName("1 - Must remove a person from an address successfully")
    public void removePersonToAddressSuccessfully() throws Exception {
        Person person = CreatePerson.createTestPerson();
        Address address = CreateAddress.createTestAddress();
        person.addAddress(address);
        personRepository.save(person);
        Person secondPerson = CreatePerson.createSecondTestPerson();
        personRepository.save(secondPerson);
        mockMvc.perform(patch("/address/remove")
                        .param("personId", String.valueOf(secondPerson.getId()))
                        .param("id", String.valueOf(address.getId())))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(2)
    @DisplayName("2 - Must throw an error if person is not found")
    public void throwAnErrorIfPersonIsNotFound() throws Exception {
        Person person = CreatePerson.createTestPerson();
        Address address = CreateAddress.createTestAddress();
        person.addAddress(address);
        personRepository.save(person);
        Person secondPerson = CreatePerson.createSecondTestPerson();
        personRepository.save(secondPerson);
        mockMvc.perform(patch("/address/remove")
                        .param("personId", String.valueOf(secondPerson.getId() + 15L))
                        .param("id", String.valueOf(address.getId())))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(3)
    @DisplayName("3 - Must throw an error if address is not found")
    public void throwAnErrorIfAddressIsNotFound() throws Exception {
        Person person = CreatePerson.createTestPerson();
        Address address = CreateAddress.createTestAddress();
        person.addAddress(address);
        personRepository.save(person);
        Person secondPerson = CreatePerson.createSecondTestPerson();
        personRepository.save(secondPerson);
        mockMvc.perform(patch("/address/remove")
                        .param("personId", String.valueOf(secondPerson.getId()))
                        .param("id", String.valueOf(address.getId() + 1500L)))
                .andExpect(status().isNotFound());
    }
}
