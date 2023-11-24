package com.brief.marjane2.controller;

import com.brief.marjane2.entity.Client;
import com.brief.marjane2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;



    @PostMapping("/Client")
    public ResponseEntity create(@RequestBody Client client){

        return clientService.create(client);

    }

}
