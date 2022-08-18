package com.example.springcqrs.command.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springcqrs.command.command.CreateAccountCommand;
import com.example.springcqrs.command.command.DepositMoneyCommand;
import com.example.springcqrs.command.command.WithdrawMoneyCommand;
import com.example.springcqrs.command.dto.CreateAccountRequest;
import com.example.springcqrs.command.dto.DepositRequest;
import com.example.springcqrs.command.dto.WithdrawalRequest;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author 
 **/
@Service
public class AccountCommandService {
	
	private static final Logger log = LoggerFactory.getLogger(AccountCommandService.class);

	@Autowired
    private CommandGateway commandGateway;

//    public AccountCommandService(CommandGateway commandGateway) {
//        this.commandGateway = commandGateway;
//    }

    public CompletableFuture<String> createAccount(CreateAccountRequest createAccountRequest) {
    	log.info("commandGateway send createAccount.");
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                createAccountRequest.getStartingBalance())
        );
    }

    public CompletableFuture<String> depositToAccount(DepositRequest depositRequest) {
    	log.info("commandGateway send depositToAccount.");
        return commandGateway.send(new DepositMoneyCommand(
                depositRequest.getAccountId(),
                depositRequest.getAmount()
        ));
    }

    public CompletableFuture<String> withdrawFromAccount(WithdrawalRequest withdrawalRequest) {
    	log.info("commandGateway send withdrawFromAccount.");
        return commandGateway.send(new WithdrawMoneyCommand(
                withdrawalRequest.getAccountId(),
                withdrawalRequest.getAmount()
        ));
    }
}