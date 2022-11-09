package com.jhson.api.person.controller;

import com.jhson.api.person.entity.Person;
import com.jhson.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Integer.*;

@Controller
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("add-person")
    @ResponseBody
    public Person add(
            @RequestParam("name") String name,
            @RequestParam("age") String age
    ) {
        Person newPerson = new Person(name, parseInt(age));
        System.out.println(newPerson);
        personRepository.add(newPerson);
        return newPerson;
    }

}
