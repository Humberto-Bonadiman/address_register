package com.br.address_register.controller;

import com.br.address_register.dto.AddressDto;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.listAllAddresses());
    }

    @Override
    public ResponseEntity<Set<Address>> listPersonAddresses(Long personId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.listPersonAddresses(personId));
    }

    @Override
    public ResponseEntity<Address> findAddressById(Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.findAddressById(id));
    }

    @Override
    public ResponseEntity<Address> updateAddressById(Long id, AddressDto addressDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.updateAddressById(id, addressDto));
    }

    @Override
    public ResponseEntity<Address> addPerson(Long personId, Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.addPerson(personId, id));
    }

    @Override
    public ResponseEntity<Address> removePerson(Long personId, Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.removePerson(personId, id));
    }

    @Override
    public ResponseEntity<Object> deletePersonById(Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
