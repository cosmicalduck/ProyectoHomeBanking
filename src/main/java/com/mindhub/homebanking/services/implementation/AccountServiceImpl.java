package com.mindhub.homebanking.services.implementation;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll().stream().map(
                AccountDTO::new).collect(toList());
    }

    @Override
    public AccountDTO findById(long id) {
        return accountRepository.findById(id).map(AccountDTO::new).orElse(null);
    }
}
