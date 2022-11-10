package com.jhson.api.home.controller;

import com.jhson.api.home.entity.ClientLog;
import com.jhson.api.home.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    @ResponseBody
    public String home(HttpServletRequest request) {
        ClientLog clientInfo = clientService.registerClientInfo(request.getRemoteAddr(), request.getRemotePort());
        return String.format("Welcome, [%s]", clientInfo.toString());
    }
}
