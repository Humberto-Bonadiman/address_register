package com.br.address_register.utils;

import com.br.address_register.dto.PersonTestDto;
import com.br.address_register.model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreatePerson {
    public static Person createTestPerson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "16/08/1998";
        LocalDate localDate = LocalDate.parse(date, formatter);
        Person person = new Person(
                "Name Test",
                localDate,
                "birthplace test",
                "birth state test",
                "nationality test"
        );
        return person;
    }

    public static Person createSecondTestPerson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "20/05/1998";
        LocalDate localDate = LocalDate.parse(date, formatter);
        Person person = new Person(
                "Second Name Test",
                localDate,
                "birthplace test",
                "birth state test",
                "nationality test"
        );
        return person;
    }

    public static PersonTestDto createPersonTestDto() {
        PersonTestDto personTestDto = new PersonTestDto(
                "Name Test",
                "1998-08-16",
                "birthplace test",
                "birth state test",
                "nationality test"
        );
        return personTestDto;
    }
}
