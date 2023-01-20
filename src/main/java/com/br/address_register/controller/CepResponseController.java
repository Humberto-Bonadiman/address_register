package com.br.address_register.controller;

import com.br.address_register.response.CepResponse;
import com.br.address_register.service.CepResponseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Tag(name = "Cep Response API")
public class CepResponseController implements CepResponseInterfaceController {

    @Autowired
    CepResponseService cepResponseService;

    @Override
    public ResponseEntity<CepResponse> findCep(String cep) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cepResponseService.getCepResponse(cep));
    }

}
