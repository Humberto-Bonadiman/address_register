package com.br.address_register.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "birthplace", nullable = false)
    private String birthplace;

    @Column(name = "birth_state", nullable = false)
    private String birthState;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "relationship_person_address",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Set<Address> addresses;

    public Person() {
        this.addresses = new HashSet<>();
    }

    public Person(
            String name,
            LocalDate birthDate,
            String birthplace,
            String birthState,
            String nationality
    ) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.birthState = birthState;
        this.nationality = nationality;
        this.addresses = new HashSet<>();
    }

    public Person(
            Long id,
            String name,
            LocalDate birthDate,
            String birthplace,
            String birthState,
            String nationality
    ) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.birthState = birthState;
        this.nationality = nationality;
        this.addresses = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.addPerson(this);
    }

    public void removeAddress(Address address) {
        address.removePerson(this);
        this.addresses.remove(address);
    }
}
