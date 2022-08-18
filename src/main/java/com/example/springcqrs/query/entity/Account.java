package com.example.springcqrs.query.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author 
 **/
@Entity
public class Account {

    @Id
    private String accountId;
    public Account() {
		super();
	}
    public Account(String accountId, BigDecimal balance, String status) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
	}

	private BigDecimal balance;
    private String status;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}