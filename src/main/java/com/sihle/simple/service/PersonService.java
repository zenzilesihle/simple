package com.sihle.simple.service;

import com.sihle.simple.model.Person;
import com.sihle.simple.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sihle.simple.model.factory.PersonFactory.newPerson;

@Service
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private Person person;
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonDetails(String id) {
        person = newPerson(personRepository.getOne(Long.parseLong(id)));

        LOGGER.info("Retrieved id: {} information", id);
        return  (person != null) ? person : new Person();
    }

    public void createPerson(Person newPerson) {
        person = newPerson(newPerson);
        personRepository.save(person);
        LOGGER.info("Successfully saved id {} information", newPerson.getId());
    }
}
