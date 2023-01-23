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
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ListPersonAddressesTest {

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
    @DisplayName("1 - Must show all addresses successfully")
    public void listPersonAddressesSuccessfully() throws Exception {
        Person person = CreatePerson.createTestPerson();
        Address firstAddress = CreateAddress.createTestAddress();
        person.addAddress(firstAddress);
        Address secondAddress = CreateAddress.createSecondTestAddress();
        person.addAddress(secondAddress);
        personRepository.save(person);
        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cep").value(firstAddress.getCep()))
                .andExpect(jsonPath("$[0].state").value(firstAddress.getState()))
                .andExpect(jsonPath("$[0].city").value(firstAddress.getCity()))
                .andExpect(jsonPath("$[0].neighborhood").value(firstAddress.getNeighborhood()))
                .andExpect(jsonPath("$[0].street").value(firstAddress.getStreet()))
                .andExpect(jsonPath("$[0].number").value(firstAddress.getNumber()))
                .andExpect(jsonPath("$[0].complement").value(firstAddress.getComplement()))
                .andExpect(jsonPath("$[1].cep").value(secondAddress.getCep()))
                .andExpect(jsonPath("$[1].state").value(secondAddress.getState()))
                .andExpect(jsonPath("$[1].city").value(secondAddress.getCity()))
                .andExpect(jsonPath("$[1].neighborhood").value(secondAddress.getNeighborhood()))
                .andExpect(jsonPath("$[1].street").value(secondAddress.getStreet()))
                .andExpect(jsonPath("$[1].number").value(secondAddress.getNumber()))
                .andExpect(jsonPath("$[1].complement").value(secondAddress.getComplement()));
    }
}
