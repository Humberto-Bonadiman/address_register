package com.br.address_register.dto;

import javax.persistence.Column;

public class AddressDto {

    private String cep;

    private String complement;

    private Long personId;

    public AddressDto() {}

    public AddressDto(String cep, String complement, Long personId) {
        this.cep = cep;
        this.complement = complement;
        this.personId = personId;
    }

    public String getCep() {
        return cep;
    }

    public String getComplement() {
        return complement;
    }

    public Long getPersonId() {
        return personId;
    }
}
