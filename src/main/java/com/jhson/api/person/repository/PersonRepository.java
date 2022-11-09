package com.jhson.api.person.repository;

import com.jhson.api.person.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Person add(Person add);
    List<Person> findAll();

    Optional<Person> findOneByName(String name);

    boolean updateAge(String name, int age);

    boolean deleteOneByName(String name);

}
