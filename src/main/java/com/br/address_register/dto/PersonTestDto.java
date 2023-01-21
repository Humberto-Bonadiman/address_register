package com.br.address_register.dto;

public class PersonTestDto {
    private String name;

    private String birthDate;

    private String birthplace;

    private String birthState;

    private String nationality;

    public PersonTestDto() {}

    public PersonTestDto(
            String name,
            String birthDate,
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


    public String getBirthDate() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
