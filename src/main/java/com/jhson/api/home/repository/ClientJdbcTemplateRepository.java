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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String strDate = dateFormat.format(clientLog.getTime());
        System.out.println(strDate);

        return jdbcTemplate.update(
                "Insert into client(ip,port,time) values(?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'))"
                , clientLog.getIp()
                , clientLog.getPort()
                , strDate
        )!=0;
    }
}
