package com.example.springcqrs.command.dto;

import java.math.BigDecimal;

/**
 * @author 
 **/
public class CreateAccountRequest {
	
	public CreateAccountRequest() {
	}
	
    private BigDecimal startingBalance;

	public CreateAccountRequest(BigDecimal startingBalance) {
		super();
		this.startingBalance = startingBalance;
	}

	public BigDecimal getStartingBalance() {
		return startingBalance;
	}

}