package com.br.address_register.controller;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.dto.UpdateAddressDto;
import com.br.address_register.model.Address;
import com.br.address_register.service.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@Tag(name = "Address")
public class AddressController implements AddressInterfaceController {

    @Autowired
    AddressService addressService;

    @Override
    public ResponseEntity<Address> createAddress(AddressDto addressDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.createAddress(addressDto));
    }

    @Override
    public ResponseEntity<List<Address>> listAllAddresses() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(addressService.listAllAddresses());
    }

    @Override
    public ResponseEntity<Set<Address>> listPersonAddresses(Long personId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(addressService.listPersonAddresses(personId));
    }

    @Override
    public ResponseEntity<Address> findAddressById(Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(addressService.findAddressById(id));
    }

    @Override
    public ResponseEntity<Address> updateAddressById(Long id, UpdateAddressDto updateAddressDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(addressService.updateAddressById(id, updateAddressDto));
    }

    @Override
    public ResponseEntity<Object> addPerson(Long personId, Long id) {
        addressService.addPerson(personId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Object> removePerson(Long personId, Long id) {
        addressService.removePerson(personId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Object> deletePersonById(Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
