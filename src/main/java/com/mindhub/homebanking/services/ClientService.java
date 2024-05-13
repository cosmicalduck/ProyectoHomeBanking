package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dtos.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {

    List<ClientDTO> findAll();

    ClientDTO findById(long id);

    ClientDTO findCurrentClient(Authentication auth);

    ResponseEntity<Object> createAccount(Authentication auth);

    ResponseEntity<Object> autoCreateAccount(String email);
}
