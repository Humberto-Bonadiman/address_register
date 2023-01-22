package com.br.address_register.service;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.dto.UpdateAddressDto;
import com.br.address_register.model.Address;

import java.util.LinkedHashSet;
import java.util.List;

public interface AddressInterface {
    Address createAddress(AddressDto addressDto);

    List<Address> listAllAddresses();

    List<Address> listPersonAddresses(Long id);

    Address findAddressById(Long id);

    Address updateAddressById(Long id, UpdateAddressDto updateAddressDto);

    void addPerson(Long personId, Long id);

    void removePerson(Long personId, Long id);

    void deleteAddressById(Long id);
}
