package com.sihle.simple.controller;

import com.sihle.simple.model.Person;
import com.sihle.simple.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {
    private PersonService personService;

    @Autowired
    public SimpleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getSimple() {
        return "This is Simple";
    }

    @GetMapping(value = "/person/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Person getPerson(@PathVariable String id) {
        return personService.getPersonDetails(id);
    }

    @PostMapping(value = "/person", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person newPerson) {
        personService.createPerson(newPerson);
    }
}

/*
{
 person : {
    "id": 1234567890,
    "name": "Micheal",
    "surname": "Junior",
    "age": 54,
    "address": "23 Forest Hills, Queens"
    }
}
* */
