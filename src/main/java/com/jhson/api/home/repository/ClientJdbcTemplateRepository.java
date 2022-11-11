package com.jhson.api.home.repository;

import com.jhson.api.home.entity.ClientInfoDTO;
import com.jhson.api.home.entity.ClientInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class ClientJdbcTemplateRepository implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClientJdbcTemplateRepository(@Autowired DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<ClientInfoVO> selectByIPPort(ClientInfoVO clientInfoVO) {
        return jdbcTemplate.query(
                "select * from client_info where ip=? and port=?"
                , rowMapper(), clientInfoVO.getIp(), clientInfoVO.getPort()
                ).stream().findAny();
    }

    @Override
    public boolean insertClientInfo(ClientInfoVO clientInfoVO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String strDate = dateFormat.format(clientInfoVO.getLastAccessTime());
        System.out.println(strDate);

        return jdbcTemplate.update(
                "Insert into client_info(ip,port,last_access_time,num_visits) values(?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?)"
                , clientInfoVO.getIp()
                , clientInfoVO.getPort()
                , strDate
                , clientInfoVO.getNumVisits()
        )!=0;
    }

    @Override
    public boolean updateClientInfo(ClientInfoVO clientInfoVO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String strDate = dateFormat.format(clientInfoVO.getLastAccessTime());
        System.out.println(strDate);

        return jdbcTemplate.update(
                "Update client_info set last_access_time=TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), num_visits=? where ip=? and port=?"
                , strDate
                , clientInfoVO.getNumVisits()
                , clientInfoVO.getIp()
                , clientInfoVO.getPort()
        )!=0;
    }

    private RowMapper<ClientInfoVO> rowMapper() {
        return (rs, rowNum) -> ClientInfoVO.clientInfoVOBuilder()
                                            .setIp(rs.getString("IP"))
                                            .setPort(rs.getInt("PORT"))
                                            .setLastAccessTime(rs.getDate("LAST_ACCESS_TIME"))
                                            .setNumVisits(rs.getInt("NUM_VISITS"))
                                            .build();
    }
}
