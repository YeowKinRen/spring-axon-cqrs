package com.example.springcqrs.command.command;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 
 **/
public class CreateAccountCommand extends BaseCommand<String> {

    private final BigDecimal balance;

    public CreateAccountCommand(String id, BigDecimal balance) {
        super(id);
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

	@Override
	public String toString() {
		return "CreateAccountCommand [balance=" + balance + ", getId()=" + getId() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(balance);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateAccountCommand other = (CreateAccountCommand) obj;
		return Objects.equals(balance, other.balance);
	}

}