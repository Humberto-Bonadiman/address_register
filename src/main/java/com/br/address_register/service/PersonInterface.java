package com.br.address_register.service;

import com.br.address_register.dto.PersonDto;
import com.br.address_register.model.Person;

import java.util.List;

public interface PersonInterface {
    Person createPerson(PersonDto personDto);

    List<Person> showAllPeople();

    Person findPersonById(Long id);

    Person editPersonById(Long id, PersonDto personDto);

    void deletePersonById(Long id);
}
