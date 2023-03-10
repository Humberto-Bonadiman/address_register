package com.br.address_register.service;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.dto.UpdateAddressDto;
import com.br.address_register.exception.messages.AddressNotFoundException;
import com.br.address_register.model.Address;
import com.br.address_register.model.Person;
import com.br.address_register.repository.AddressRepository;
import com.br.address_register.repository.PersonRepository;
import com.br.address_register.response.CepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements AddressInterface {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    CepResponseService cepResponseService;

    @Override
    public Address createAddress(AddressDto addressDto) {
        CepResponse cepResponse = cepResponseService.getCepResponse(addressDto.getCep());
        Address address = new Address(
                cepResponse.getCep(),
                cepResponse.getState(),
                cepResponse.getCity(),
                cepResponse.getNeighborhood(),
                cepResponse.getStreet(),
                addressDto.getNumber(),
                addressDto.getComplement()
        );
        Person person = personService.findByIdOrThrowError(addressDto.getPersonId());
        person.addAddress(address);
        Person saved = personRepository.save(person);
        return saved.getAddresses().get(saved.getAddresses().size() - 1);
    }

    @Override
    public List<Address> listAllAddresses() {
        return addressRepository.findAll();
    }


    @Override
    public List<Address> listPersonAddresses(Long id) {
        Person person = personService.findByIdOrThrowError(id);
        return person.getAddresses();
    }

    @Override
    public Address findAddressById(Long id) {
        return findByIdOrThrowError(id);
    }

    @Override
    public Address updateAddressById(Long id,  UpdateAddressDto updateAddressDto) {
        Address address = findByIdOrThrowError(id);
        CepResponse cepResponse = cepResponseService.getCepResponse(updateAddressDto.getCep());
        address.setCep(cepResponse.getCep());
        address.setState(cepResponse.getState());
        address.setCity(cepResponse.getCity());
        address.setNeighborhood(cepResponse.getNeighborhood());
        address.setStreet(cepResponse.getStreet());
        address.setNumber(updateAddressDto.getNumber());
        address.setComplement(updateAddressDto.getComplement());
        return address;
    }

    @Override
    public void addPerson(Long personId, Long id) {
        Person person = personService.findByIdOrThrowError(personId);
        Address address = findByIdOrThrowError(id);
        person.addAddress(address);
        personRepository.save(person);
    }

    @Override
    public void removePerson(Long personId, Long id) {
        Person person = personService.findByIdOrThrowError(personId);
        Address address = findByIdOrThrowError(id);
        person.removeAddress(address);
        personRepository.save(person);
    }

    @Override
    public void deleteAddressById(Long id) {
        findByIdOrThrowError(id);
        addressRepository.deleteById(id);
    }

    private Address findByIdOrThrowError(Long id) {
        Optional<Address> validAddress = addressRepository.findById(id);
        if (validAddress.isEmpty()) {
            throw new AddressNotFoundException();
        }
        return validAddress.get();
    }
}
