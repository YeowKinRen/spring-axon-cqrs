package com.example.springcqrs.command.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springcqrs.command.aggregate.AccountAggregate;
import com.example.springcqrs.command.dto.CreateAccountRequest;
import com.example.springcqrs.command.dto.DepositRequest;
import com.example.springcqrs.command.dto.WithdrawalRequest;
import com.example.springcqrs.command.service.AccountCommandService;

import java.util.concurrent.CompletableFuture;

/**
 * @author 
 **/
@RestController
@RequestMapping(value = "/bank-account")
public class BankAccountController {
	private static final Logger log = LoggerFactory.getLogger(BankAccountController.class);

	@Autowired
    private AccountCommandService accountCommandService;

//    public BankAccountController(AccountCommandService accountCommandService) {
//        this.accountCommandService = accountCommandService;
//    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest request) {
        try {
            CompletableFuture<String> response =
                    accountCommandService.createAccount(request);

            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch (Exception e) {
        	log.error(e.toString());
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositRequest request) {
        try {
            accountCommandService.depositToAccount(request);

            return new ResponseEntity<>("Amount credited", HttpStatus.OK);
        } catch (Exception e) {
        	log.error(e.toString());
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawalRequest request) {
        try {
            accountCommandService.withdrawFromAccount(request);

            return new ResponseEntity<>("Amount debited.", HttpStatus.OK);
        } catch (Exception e) {
        	log.error(e.toString());
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}