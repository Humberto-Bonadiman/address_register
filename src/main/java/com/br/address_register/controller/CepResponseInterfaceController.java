package com.br.address_register.controller;

import com.br.address_register.response.CepResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CepResponseInterfaceController {

    @GetMapping("/{cep}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find a cep",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CepResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "Cep not found",
                    content = @Content)})
    @Operation(summary = "Find a cep")
    ResponseEntity<CepResponse> findCep(@PathVariable String cep);
}
