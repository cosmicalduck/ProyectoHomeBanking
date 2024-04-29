package com.mindhub.homebanking.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.services.AccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/accounts")
    @JsonIgnore
    public List<AccountDTO> getAllAccounts(){
        return this.accountService.findAll();
    }

    @RequestMapping("/accounts/{id}")
    public AccountDTO getAccountById(@PathVariable long id){
        return this.accountService.findById(id);

    }

}
