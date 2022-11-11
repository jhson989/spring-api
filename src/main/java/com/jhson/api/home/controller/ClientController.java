package com.jhson.api.home.controller;

import com.jhson.api.home.entity.ClientInfoDTO;
import com.jhson.api.home.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String home(
            HttpServletRequest request
    ) {
        ClientInfoDTO clientInfo = new ClientInfoDTO();
        clientInfo.setIp(request.getRemoteAddr());
        clientInfo.setPort(request.getRemotePort());
        clientInfo.setAccessTime(new Date());
        clientService.writeClientInfo(clientInfo);

        return String.format("Welcome, [%s]", clientInfo.toString());
    }
}
