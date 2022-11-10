package com.jhson.api.home.repository;

import com.jhson.api.home.entity.ClientLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;

public class ClientJdbcTemplateRepository implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClientJdbcTemplateRepository(@Autowired DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public boolean addClientLog(ClientLog clientLog) {
        System.out.println("1");
        System.out.println(clientLog.getTime());
        System.out.println("2");
        long currentMilliseconds = clientLog.getTime().getTime();
        System.out.println(currentMilliseconds);
        java.sql.Date sqlDate = new java.sql.Date(currentMilliseconds);
        System.out.println(sqlDate);
        System.out.println("3");
        return jdbcTemplate.update("Insert into client(ip,port,time) values(?,?,?)", clientLog.getIp(), clientLog.getPort(), sqlDate)!=0;
    }
}
