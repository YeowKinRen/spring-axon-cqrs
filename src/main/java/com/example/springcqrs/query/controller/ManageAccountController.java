package com.example.springcqrs.query.controller;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcqrs.query.entity.Account;
import com.example.springcqrs.query.query.FindAccountByIdQuery;

/**
 * @author 
 **/
@RestController
@RequestMapping(value = "/manage-account")
public class ManageAccountController {
	
	@Autowired
    private QueryGateway queryGateway;

//    public ManageAccountController(QueryGateway queryGateway) {
//        this.queryGateway = queryGateway;
//    }

    @GetMapping("/get-account")
    public ResponseEntity<Account> getAccount(@RequestParam String id) {
        Account account = queryGateway.query(
                new FindAccountByIdQuery(id), Account.class
        ).join();

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}