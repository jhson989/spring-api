package com.jhson.api.config;

import com.jhson.api.home.repository.ClientJdbcTemplateRepository;
import com.jhson.api.home.repository.ClientRepository;
import com.jhson.api.person.repository.PersonJdbcTemplateRepository;
import com.jhson.api.person.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    private final DataSource dataSource;

    public RepositoryConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PersonRepository personRepository() {
        return new PersonJdbcTemplateRepository(dataSource);
    }

    @Bean
    public ClientRepository clientRepository() {
        return new ClientJdbcTemplateRepository(dataSource);
    }

}
