package com.sihle.simple.model.factory;

import com.sihle.simple.model.Person;

public class PersonFactory {
    public static Person newPerson(Person newPerson) {
        new Person();
        return Person.builder()
                .id(newPerson.getId())
                .name(newPerson.getName())
                .surname(newPerson.getSurname())
                .age(newPerson.getAge())
                .address(newPerson.getAddress())
                .build();
    }
}
