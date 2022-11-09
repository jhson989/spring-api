package com.jhson.api.person.repository;

import com.jhson.api.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class OraclePersonRepository implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    public OraclePersonRepository(@Autowired DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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

}
