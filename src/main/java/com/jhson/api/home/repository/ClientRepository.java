package com.jhson.api.home.repository;

import com.jhson.api.home.entity.ClientInfoVO;

import java.util.Optional;

public interface ClientRepository {

    public Optional<ClientInfoVO> selectByIPPort(ClientInfoVO clientInfoVO);
    public boolean insertClientInfo(ClientInfoVO clientInfoVO);
    public boolean updateClientInfo(ClientInfoVO clientInfoVO);

}
