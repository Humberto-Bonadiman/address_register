package com.br.address_register.service;

import com.br.address_register.response.CepResponse;
import org.springframework.web.client.RestTemplate;

public class CepResponseService {

    public CepResponse getCepResponse(String cep) {
        String uri = "https://brasilapi.com.br/api/cep/v1/" + cep;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, CepResponse.class);
    }
}
