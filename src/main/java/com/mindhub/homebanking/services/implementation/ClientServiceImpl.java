package com.mindhub.homebanking.services.implementation;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
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
}