package com.br.address_register.controller;

import com.br.address_register.dto.AddressDto;
import com.br.address_register.dto.UpdateAddressDto;
import com.br.address_register.model.Address;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;

@RequestMapping("/address")
public interface AddressInterfaceController {

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create address",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Address.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found",
                    content = @Content)
    })
    @Operation(summary = "Create address")
    ResponseEntity<Address> createAddress(@RequestBody AddressDto addressDto);

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Show all address",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Address.class)))})
    })
    @Operation(summary = "Show all addresses")
    ResponseEntity<List<Address>> listAllAddresses();

    @GetMapping("/find_all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Show all person addresses",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Address.class)))}),
            @ApiResponse(responseCode = "404", description = "Person addresses not found",
                    content = @Content)
    })
    @Operation(summary = "Show all person addresses")
    ResponseEntity<List<Address>> listPersonAddresses(@RequestParam Long personId);

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find an address by id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Address.class)) }),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content)})
    @Operation(summary = "Find an address by id")
    ResponseEntity<Address> findAddressById(@PathVariable Long id);

    @PatchMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Address.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content)})
    @Operation(summary = "Update address by id")
    ResponseEntity<Address> updateAddressById(
            @PathVariable Long id,
            @RequestBody UpdateAddressDto updateAddressDto
    );

    @PatchMapping("/add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content)})
    @Operation(summary = "Add person in address by id")
    ResponseEntity<Object> addPerson(
            @RequestParam Long personId,
            @RequestParam Long id
    );

    @PatchMapping("/remove")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content)})
    @Operation(summary = "Remove person in address by id")
    ResponseEntity<Object> removePerson(
            @RequestParam Long personId,
            @RequestParam Long id
    );

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content)})
    @Operation(summary = "Delete address by id")
    ResponseEntity<Object> deletePersonById(@PathVariable Long id);
}
