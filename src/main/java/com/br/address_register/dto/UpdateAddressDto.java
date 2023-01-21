package com.br.address_register.dto;

public class UpdateAddressDto {

    private String cep;

    private Long number;

    private String complement;

    public UpdateAddressDto(String cep, Long number, String complement) {
        this.cep = cep;
        this.number = number;
        this.complement = complement;
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
}
