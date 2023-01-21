package com.br.address_register.service;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.model.Address;

import java.util.List;
import java.util.Set;

public interface AddressInterface {
    Address createAddress(AddressDto addressDto);

    List<Address> listAllAddresses();

    Set<Address> listPersonAddresses(Long id);

    Address findAddressById(Long id);

    Address updateAddressById(Long id, AddressDto addressDto);

    Address addPerson(Long personId, Long id);

    Address removePerson(Long personId, Long id);

    void deleteAddressById(Long id);
}
