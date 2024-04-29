package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dtos.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {

    List<ClientDTO> findAll();

    ClientDTO findById(long id);
}
