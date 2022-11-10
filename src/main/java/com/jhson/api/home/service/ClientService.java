package com.jhson.api.home.service;

import com.jhson.api.home.entity.ClientLog;
import com.jhson.api.home.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientLog registerClientInfo(String clientIp, int clientPort) {
        ClientLog clientLog = new ClientLog();
        clientLog.setIp(clientIp).setPort(clientPort).setTime(new Date());
        clientRepository.addClientLog(clientLog);
        return clientLog;
    }
}
