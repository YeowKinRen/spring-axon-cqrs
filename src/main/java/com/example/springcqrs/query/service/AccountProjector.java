package com.example.springcqrs.query.service;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springcqrs.command.aggregate.AccountAggregate;
import com.example.springcqrs.common.event.AccountActivatedEvent;
import com.example.springcqrs.common.event.AccountCreatedEvent;
import com.example.springcqrs.common.event.AccountCreditedEvent;
import com.example.springcqrs.common.event.AccountDebitedEvent;
import com.example.springcqrs.query.entity.Account;
import com.example.springcqrs.query.query.FindAccountByIdQuery;
import com.example.springcqrs.query.repository.AccountRepository;

/**
 * @author 
 **/
@Service
@ProcessingGroup("Account")
public class AccountProjector {
	
	private static final Logger log = LoggerFactory.getLogger(AccountProjector.class);

	@Autowired
    private AccountRepository accountRepository;

//    public AccountProjector(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        log.info("Handling AccountCreatedEvent...");
        Account account = new Account();
        account.setAccountId(accountCreatedEvent.getId());
        account.setBalance(accountCreatedEvent.getBalance());
        account.setStatus("CREATED");

        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent accountActivatedEvent) {
        log.info("Handling AccountActivatedEvent...");
        Account account = accountRepository.findById(accountActivatedEvent.getId()).orElse(null);

        if (account != null) {
            account.setStatus(accountActivatedEvent.getStatus());
            accountRepository.save(account);
        }
    }
    @EventHandler
    public void on(AccountCreditedEvent accountCreditedEvent) {
        log.info("Handling AccountCreditedEvent...");
        Account account = accountRepository
                .findById(accountCreditedEvent.getId()).orElse(null);

        if (account != null) {
            account.setBalance(account.getBalance()
                    .add(accountCreditedEvent.getAmount()));
        }
    }
    @EventHandler
    public void on(AccountDebitedEvent accountDebitedEvent) {
        log.info("Handling AccountDebitedEvent...");
        Account account = accountRepository
                .findById(accountDebitedEvent.getId()).orElse(null);

        if (account != null) {
            account.setBalance(account.getBalance()
                    .subtract(accountDebitedEvent.getAmount()));
        }
    }

    @QueryHandler
    public Account handle(FindAccountByIdQuery query) {
        log.info("Handling FindAccountByIdQuery...");
        Account account = accountRepository
                .findById(query.getAccountId()).orElse(null);

        return account;
    }
}