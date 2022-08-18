package com.example.springcqrs.command.dto;

import java.math.BigDecimal;

/**
 * @author 
 **/
public class WithdrawalRequest {

    private String accountId;
    private BigDecimal amount;
	public WithdrawalRequest(String accountId, BigDecimal amount) {
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