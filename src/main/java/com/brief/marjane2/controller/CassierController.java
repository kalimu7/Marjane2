package com.brief.marjane2.controller;

import com.brief.marjane2.entity.Caissier;
import com.brief.marjane2.entity.Client;
import com.brief.marjane2.service.CaissierService;
import com.brief.marjane2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Caissier")
public class CassierController {


    @Autowired
    private  CaissierService caissierService;

    @Autowired
    private ClientService clientService;



    @PostMapping("")
    public ResponseEntity create(@RequestBody Caissier caissier){

        return caissierService.create(caissier);

    }

    @PostMapping("/Client")
    public ResponseEntity create(@RequestBody Client client){

        return clientService.create(client);

    }



}
