package com.br.address_register.dto;

import javax.persistence.Column;

public class TestAddressDto {

    private String cep;

    private String state;

    private String city;

    private String neighborhood;

    private String street;

    private Long number;

    private String complement;

    private Long personId;

    public TestAddressDto(
            String cep,
            String state,
            String city,
            String neighborhood,
            String street,
            Long number,
            String complement,
            Long personId
    ) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.personId = personId;
    }
}
