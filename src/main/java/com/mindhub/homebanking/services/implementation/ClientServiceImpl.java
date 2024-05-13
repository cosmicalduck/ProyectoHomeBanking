package com.mindhub.homebanking.services.implementation;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.services.ClientService;
import com.mindhub.homebanking.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private ClientServiceImpl(ClientRepository clientRepository, AccountRepository accountRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(
                ClientDTO::new).collect(toList());
    }

    @Override
    public ClientDTO findById(long id) {
        return clientRepository.findById(id).map(ClientDTO::new).orElse(null);
    }

    @Override
    public ClientDTO findCurrentClient(Authentication auth) {
        return clientRepository.findByEmail(auth.getName()).map(ClientDTO::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createAccount(Authentication auth) {
       Optional<Client> auxClient = clientRepository.findByEmail(auth.getName());
       if(auxClient.isPresent()){
           if(auxClient.get().getAccounts().isEmpty() || auxClient.get().getAccounts().size() < 3){
               LocalDate fechaHoy = LocalDate.now();
               Account account = accountRepository.save(new Account(Utils.generateAccountNumber(8), fechaHoy, 0));
               account.setClient(auxClient.get());
               accountRepository.save(account);
               return new ResponseEntity<>("creada", HttpStatus.CREATED);
           } else {
               return new ResponseEntity<>("prohibido", HttpStatus.FORBIDDEN);
           }
       } else {
           return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
       }
    }

    @Override
    public ResponseEntity<Object> autoCreateAccount(String email) {
        Optional<Client> auxClient = clientRepository.findByEmail(email);
        if(auxClient.isPresent()){
            if(auxClient.get().getAccounts().isEmpty() || auxClient.get().getAccounts().size() < 3){
                LocalDate fechaHoy = LocalDate.now();
                Account account = accountRepository.save(new Account(Utils.generateAccountNumber(8), fechaHoy, 0));
                account.setClient(auxClient.get());
                accountRepository.save(account);
                return new ResponseEntity<>("creada", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("prohibido", HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
        }
    }


}
