package com.brief.marjane2.service;

import com.brief.marjane2.entity.CarteFidelité;
import com.brief.marjane2.entity.Client;
import com.brief.marjane2.repository.CarteFidilteRepository;
import com.brief.marjane2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarteFidilteRepository carteFidilteRepository;

    public Client createClient(Client client){

        return clientRepository.save(client);

    }

    public CarteFidelité createCarte(CarteFidelité carteFidelité){
        Optional<Client> client =  clientRepository.findById(carteFidelité.getClient().getId());

        String code = UUID.randomUUID().toString();
        carteFidelité.setCode(code);
        return carteFidilteRepository.save(carteFidelité);
    }




    public CarteFidelité create(Client client) {

        Client client1 = clientRepository.save(client);
        return createCarte(client1);

    }

    public CarteFidelité createCarte(Client client) {

        CarteFidelité carteFidelité = new CarteFidelité();
        carteFidelité.setClient(client);
        carteFidelité.setAmount(0);
        String code = UUID.randomUUID().toString();
        System.out.println("code " + code);
        System.out.println("amount " + carteFidelité.getAmount());
        carteFidelité.setCode(code);

        return carteFidilteRepository.save(carteFidelité);


    }
}
