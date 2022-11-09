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
        return personRepository.add(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOneByName(String name) {

        Optional<Person> person = personRepository.findOneByName(name);
        return person.orElse(null);
    }

    public boolean deleteOneByName(String name) {
        return personRepository.deleteOneByName(name);
    }
}
