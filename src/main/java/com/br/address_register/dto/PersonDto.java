package com.br.address_register.dto;

import java.time.LocalDate;

public class PersonDto {

    private String name;

    private LocalDate birthDate;

    private String birthplace;

    private String birthState;

    private String nationality;

    private Long addressId;

    public PersonDto() {}

    public PersonDto(
            String name,
            LocalDate birthDate,
            String birthplace,
            String birthState,
            String nationality,
            Long addressId
    ) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.birthState = birthState;
        this.nationality = nationality;
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getBirthState() {
        return birthState;
    }

    public String getNationality() {
        return nationality;
    }

    public Long getAddressId() {
        return addressId;
    }
}
