package com.lucasferreira.logistics.controller;

import com.lucasferreira.logistics.domain.model.Client;
import com.lucasferreira.logistics.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    public List<Client> listAll() {
        return clientService.listAll();
    }
}
