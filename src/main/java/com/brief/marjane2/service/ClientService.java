package com.brief.marjane2.service;

import com.brief.marjane2.entity.Client;
import com.brief.marjane2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity create(Client client ){

        try{
            return ResponseEntity.ok(clientRepository.save(client));
        }catch (Exception e){
            return new ResponseEntity<>("Not created",HttpStatus.BAD_REQUEST);
        }

    }


}
