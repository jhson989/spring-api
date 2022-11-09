package com.jhson.api.person.controller;

import com.jhson.api.person.entity.Person;
import com.jhson.api.person.repository.PersonRepository;
import com.jhson.api.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.lang.Integer.*;

@Controller
public class PersonController {

    //private final PersonRepository personRepository;
    private final PersonService personService;

    @Autowired
    public PersonController(PersonRepository personRepository, PersonService personService) {
        //this.personRepository = personRepository;
        this.personService = personService;
    }

    /* *************************************************************************************
     * Create
     * ex) 0.0.0.0/person/add?name={name(str)}&age={age(int)}
     * *************************************************************************************/
    @GetMapping("/person/add")
    @ResponseBody
    public Person add(
            @RequestParam("name") String name,
            @RequestParam("age") String age
    ) {
        return personService.add(name, parseInt(age));
    }


    /* *************************************************************************************
     * Read
     * - Read all items
     *      ex) 0.0.0.0/person/show/
     * - Read an item
     *      ex) 0.0.0.0/person/show/{name(str)}
     * *************************************************************************************/
    @GetMapping("/person/show")
    @ResponseBody
    public List<Person> showAll() {
        return personService.findAll();
    }

    @GetMapping("/person/show/{name}")
    @ResponseBody
    public Person showOneByName(
            @PathVariable("name") String name
    ) {
        return personService.findOneByName(name);
    }


    /* *************************************************************************************
     * Update
     * ex) 0.0.0.0/person/update?name={name(str)}&age={age(int)}
     * *************************************************************************************/
    @GetMapping("/person/update")
    @ResponseBody
    public String updateAge(
            @RequestParam("name") String name,
            @RequestParam("age") String age
    ) {
        return Boolean.toString(personService.updateAge(name, parseInt(age)));
    }

    /* *************************************************************************************
     * Delete
     * ex) 0.0.0.0/person/delete/{name(str)}
     * *************************************************************************************/
    @GetMapping("/person/delete/{name}")
    @ResponseBody
    public String deleteOneByName(
            @PathVariable("name") String name
    ) {
        return Boolean.toString(personService.deleteOneByName(name));
    }

}
