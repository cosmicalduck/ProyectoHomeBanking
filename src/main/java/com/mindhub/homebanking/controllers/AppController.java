package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    public AppController(PasswordEncoder passwordEncoder, ClientRepository clientRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
    }

    @PostMapping(path = "/clients")
    public ResponseEntity<Object> register(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (clientRepository.findByEmail(email).isPresent()) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }

        clientRepository.save(new Client(firstName, lastName, email, passwordEncoder.encode(password)));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}