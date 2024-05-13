package com.mindhub.homebanking.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/clients")
    @JsonIgnore
    public List<ClientDTO> getClientes(){
        return clientService.findAll();
    }

    @RequestMapping("/clients/{id}")
    public ClientDTO getClientePorId(@PathVariable long id){
        return clientService.findById(id);
    }

    @RequestMapping("clients/current")
    public ClientDTO getCurrentClient(){
        return clientService.findCurrentClient(SecurityContextHolder.getContext().getAuthentication());
    }

    @RequestMapping(value = "clients/current/accounts", method = RequestMethod.POST)
    public ResponseEntity<Object> createAccount(){
        return clientService.createAccount(SecurityContextHolder.getContext().getAuthentication());
    }
}
