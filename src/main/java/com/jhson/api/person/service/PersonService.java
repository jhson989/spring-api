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
        Person person = Person.builder().setName(name).setAge(age).build();
        return personRepository.add(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOneByName(String name) {

        Optional<Person> person = personRepository.findOneByName(name);
        return person.orElse(null);
    }

    public boolean updateAge(String name, int age) {
        return personRepository.updateAge(name, age);
    }

    public boolean deleteOneByName(String name) {
        return personRepository.deleteOneByName(name);
    }

}
