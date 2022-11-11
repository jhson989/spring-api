package com.jhson.api.home.service;

import com.jhson.api.home.entity.ClientInfoDTO;
import com.jhson.api.home.entity.ClientInfoVO;
import com.jhson.api.home.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientInfoDTO writeClientInfo(ClientInfoDTO clientInfoDTO) {

        // Check whether it exists or not
        Optional<ClientInfoVO> optionalClientInfoVO = clientRepository.selectByIPPort(ClientInfoVO.toVO(clientInfoDTO));

        if (optionalClientInfoVO.isPresent()) { // If there is
            System.out.println("update");
            System.out.println(ClientInfoVO.toVO(clientInfoDTO, optionalClientInfoVO.get().getNumVisits()).getNumVisits());
            clientRepository.updateClientInfo(ClientInfoVO.toVO(clientInfoDTO, optionalClientInfoVO.get().getNumVisits()));
        } else { // If there isn't
            System.out.println("insert");
            System.out.println(ClientInfoVO.toVO(clientInfoDTO).getNumVisits());
            clientRepository.insertClientInfo(ClientInfoVO.toVO(clientInfoDTO));
        }

        return clientInfoDTO;
    }
}
