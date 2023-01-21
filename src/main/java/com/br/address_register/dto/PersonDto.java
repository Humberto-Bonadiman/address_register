package com.br.address_register.dto;

import java.time.LocalDate;

public class PersonDto {

    private String name;

    private LocalDate birthDate;

    private String birthplace;

    private String birthState;

    private String nationality;

    public PersonDto() {}

    public PersonDto(
            String name,
            LocalDate birthDate,
            String birthplace,
            String birthState,
            String nationality
    ) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.birthState = birthState;
        this.nationality = nationality;
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
}
