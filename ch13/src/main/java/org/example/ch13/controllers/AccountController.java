package org.example.ch13.controllers;

import org.example.ch13.models.Account;
import org.example.ch13.models.TransferDTO;
import org.example.ch13.services.TransferService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferDTO request) {
        transferService.transferMoney(request.getSenderAccountId(),
                                    request.getReceiverAccountId(),
                                    request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }
}