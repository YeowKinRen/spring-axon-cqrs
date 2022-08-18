package com.example.springcqrs.command.dto;

import java.math.BigDecimal;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(startingBalance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateAccountRequest other = (CreateAccountRequest) obj;
		return Objects.equals(startingBalance, other.startingBalance);
	}

	public void setStartingBalance(BigDecimal startingBalance) {
		this.startingBalance = startingBalance;
	}

	@Override
	public String toString() {
		return "CreateAccountRequest [startingBalance=" + startingBalance + "]";
	}
}