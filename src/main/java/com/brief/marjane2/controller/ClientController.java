package com.brief.marjane2.controller;

import com.brief.marjane2.entity.CarteFidelité;
import com.brief.marjane2.entity.Client;
import com.brief.marjane2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;



    @PostMapping("")
    public ResponseEntity create(@RequestBody Client client){
        try{
            return ResponseEntity.ok(clientService.createClient(client));
        }catch (Exception e){
            return new ResponseEntity<>("not created", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cart")
    public ResponseEntity createCarte(@RequestBody CarteFidelité carteFidelité){
        try {
            return ResponseEntity.ok(clientService.createCarte(carteFidelité));
        }catch (Exception e){
            return new ResponseEntity<>("not created",HttpStatus.BAD_REQUEST);
        }
    }


}
