package com.jhson.api.person.repository;

import com.jhson.api.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonJdbcTemplateRepository implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    public PersonJdbcTemplateRepository(@Autowired DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    /* *************************************************************************************
     * Create
     * *************************************************************************************/
    @Override
    public Person add(Person person) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("person").usingColumns("name", "age");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", person.getName());
        parameters.put("age", person.getAge());
        jdbcInsert.execute(parameters);

        return person;
    }


    /* *************************************************************************************
     * Read
     * *************************************************************************************/
    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query(
                "select * from person", personRowMapper()
        );
    }

    @Override
    public Optional<Person> findOneByName(String name) {
        List<Person> results = jdbcTemplate.query("select * from person where name=?", personRowMapper(), name);
        return results.stream().findAny();
    }


    /* *************************************************************************************
     * Update
     * *************************************************************************************/
    @Override
    public boolean updateAge(String name, int age) {
        return (jdbcTemplate.update("update person set age=? where name = ?", age, name) != 0);
    }


    /* *************************************************************************************
     * Delete
     * *************************************************************************************/
    @Override
    public boolean deleteOneByName(String name) {
        return (jdbcTemplate.update("delete from person where name = ?", name) != 0);
    }


    /* *************************************************************************************
     * Private method
     * *************************************************************************************/
    private RowMapper<Person> personRowMapper() {
        return (rs, rowNum) -> Person.builder()
                                .setName(rs.getString("name"))
                                .setAge(rs.getInt("age"))
                                .build();
    }

}
