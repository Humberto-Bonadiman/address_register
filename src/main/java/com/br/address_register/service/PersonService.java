package com.br.address_register.service;

import com.br.address_register.dto.PersonDto;
import com.br.address_register.exception.messages.PersonNotFoundException;
import com.br.address_register.model.Person;
import com.br.address_register.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonInterface {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person createPerson(PersonDto personDto) {
        Person person = new Person(
                personDto.getName(),
                personDto.getBirthDate(),
                personDto.getBirthplace(),
                personDto.getBirthState(),
                personDto.getNationality()
        );
        personRepository.save(person);
        return person;
    }

    @Override
    public List<Person> showAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return findByIdOrThrowError(id);
    }

    @Override
    public Person editPersonById(Long id, PersonDto personDto) {
        Person person = findByIdOrThrowError(id);
        person.setName(personDto.getName());
        person.setBirthDate(personDto.getBirthDate());
        person.setBirthplace(personDto.getBirthplace());
        person.setBirthState(personDto.getBirthState());
        person.setNationality(personDto.getNationality());
        personRepository.save(person);
        return person;
    }

    @Override
    public void deletePersonById(Long id) {
        findByIdOrThrowError(id);
        personRepository.deleteById(id);
    }

    public Person findByIdOrThrowError(Long id) {
        Optional<Person> validPerson = personRepository.findById(id);
        if (validPerson.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return validPerson.get();
    }
}
