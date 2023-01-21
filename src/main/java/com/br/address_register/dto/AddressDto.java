package com.br.address_register.dto;

import javax.persistence.Column;

public class AddressDto {

    private String cep;

    private Long number;

    private String complement;

    private Long personId;

    public AddressDto() {}

    public AddressDto(String cep, Long number, String complement, Long personId) {
        this.cep = cep;
        this.number = number;
        this.complement = complement;
        this.personId = personId;
    }

    public String getCep() {
        return cep;
    }

    public Long getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public Long getPersonId() {
        return personId;
    }
}
