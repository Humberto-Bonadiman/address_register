package com.br.address_register.utils;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.dto.UpdateAddressDto;
import com.br.address_register.model.Address;

public class CreateAddress {

    public static Address createTestAddress() {
        return new Address(
                "01310930",
                "SP",
                "São Paulo",
                "Bela Vista",
                "Avenida Paulista, 2100",
                1990L,
                "Apartamento 210"
        );
    }

    public static Address createSecondTestAddress() {
        return new Address(
                "01310931",
                "SP",
                "São Paulo",
                "Bela Vista",
                "Avenida Paulista, 2166",
                2590L,
                "Apartamento 315"
        );
    }

    public static AddressDto createTestAddressDto(Long personId) {
        return new AddressDto(
                "01310930",
                1990L,
                "Apartamento 210",
                personId
        );
    }

    public static UpdateAddressDto createTestUpdateAddressDto() {
        return new UpdateAddressDto(
                "01310931",
                2590L,
                "Apartamento 315"
        );
    }
}
