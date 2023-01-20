package com.br.address_register.controller;

import com.br.address_register.response.CepResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@Tag(name = "Cep Response API")
public class CepResponseController implements CepResponseInterfaceController {

    @Override
    public ResponseEntity<CepResponse> findCep(String cep) {
        String uri = "https://brasilapi.com.br/api/cep/v1/" + cep;
        RestTemplate restTemplate = new RestTemplate();
        CepResponse cepResponse = restTemplate.getForObject(uri, CepResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(cepResponse);
    }

}
