package com.br.address_register.AddressTests;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.model.Address;
import com.br.address_register.model.Person;
import com.br.address_register.repository.AddressRepository;
import com.br.address_register.repository.PersonRepository;
import com.br.address_register.response.CepResponse;
import com.br.address_register.service.AddressService;
import com.br.address_register.service.CepResponseService;
import com.br.address_register.utils.CreateAddress;
import com.br.address_register.utils.CreatePerson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateAddressTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CepResponseService cepResponseService;

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
        when(cepResponseService.getCepResponse("01310930"))
                .thenReturn(new CepResponse(
                        "01310930",
                        "SP",
                        "São Paulo",
                        "Bela Vista",
                        "Avenida Paulista, 2100",
                        "correios"
                ));
    }

    @AfterEach
    public void afterEach() {
        personRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("1 - Must register an address successfully")
    public void createAddressSuccessfully() throws Exception {
        Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        AddressDto addressdto = CreateAddress.createTestAddressDto(person.getId());

        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addressdto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Order(2)
    @DisplayName("2 - Must throw a error without cep")
    void badRequestWithoutCep() throws Exception {
        final Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        AddressDto addressDto = new AddressDto();
        addressDto.setNumber(1990L);
        addressDto.setComplement("Apartamento 210");
        addressDto.setPersonId(person.getId());
        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addressDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(3)
    @DisplayName("3 - Must throw a error without number")
    void badRequestWithoutNumber() throws Exception {
        final Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        AddressDto addressDto = new AddressDto();
        addressDto.setCep("01310930");
        addressDto.setComplement("Apartamento 210");
        addressDto.setPersonId(person.getId());
        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addressDto)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Order(4)
    @DisplayName("4 - Must throw a error without person id")
    void badRequestWithoutPersonId() throws Exception {
        final Person person = CreatePerson.createTestPerson();
        personRepository.save(person);
        AddressDto addressDto = new AddressDto();
        addressDto.setCep("01310930");
        addressDto.setNumber(1990L);
        addressDto.setComplement("Apartamento 210");
        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addressDto)))
                .andExpect(status().isBadRequest());
    }
}
