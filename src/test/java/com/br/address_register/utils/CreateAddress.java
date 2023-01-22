package com.br.address_register.utils;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.dto.UpdateAddressDto;
import com.br.address_register.model.Address;

public class CreateAddress {

    public static Address createTestAddress() {
        Address address = new Address(
                "01310930",
                "SP",
                "São Paulo",
                "Bela Vista",
                "Avenida Paulista, 2100",
                1990L,
                "Apartamento 210"
        );
        return address;
    }

    public static Address createSecondTestAddress() {
        Address address = new Address(
                "01310931",
                "SP",
                "São Paulo",
                "Bela Vista",
                "Avenida Paulista, 2166",
                2590L,
                "Apartamento 315"
        );
        return address;
    }

    public static AddressDto createTestAddressDto(Long personId) {
        AddressDto addressDto = new AddressDto(
                "01310930",
                1990L,
                "Apartamento 210",
                personId
        );
        return addressDto;
    }

    public static UpdateAddressDto createTestUpdateAddressDto() {
        UpdateAddressDto updateAddressDto = new UpdateAddressDto(
                "01310930",
                1990L,
                "Apartamento 210"
        );
        return updateAddressDto;
    }
}
