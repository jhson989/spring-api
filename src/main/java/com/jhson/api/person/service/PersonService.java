package com.jhson.api.person.service;

import com.jhson.api.person.entity.Person;
import com.jhson.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person add(String name, int age) {
        Person person = new Person(name, age);
        personRepository.add(person);
        return person;
    }

    public List<Person> findAll() {
        List<Person> people = personRepository.findAll();
        return people;
    }

    public Person findOneByName(String name) {

        Optional<Person> person = personRepository.findOneByName(name);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }

    public boolean deleteOneByName(String name) {
        return personRepository.deleteOneByName(name);
    }
}
