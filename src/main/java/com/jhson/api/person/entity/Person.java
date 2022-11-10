package com.jhson.api.person.entity;

import java.util.Objects;

public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static final class PersonBuilder {
        private String name;
        private int age;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.name = this.name;
            person.age = this.age;
            return person;
        }
    }


    @Override
    public String toString() {
        return String.format("Person: name(%s), age(%d)", this.name, this.age);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
