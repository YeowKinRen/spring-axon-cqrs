package com.example.springcqrs.command.dto;

import java.math.BigDecimal;

/**
 * @author
 **/
public class DepositRequest {

    private String accountId;
    private BigDecimal amount;
    
	public DepositRequest(String accountId, BigDecimal amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}