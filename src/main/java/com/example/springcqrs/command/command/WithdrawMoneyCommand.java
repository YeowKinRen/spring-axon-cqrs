package com.example.springcqrs.command.command;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 
 **/
public class WithdrawMoneyCommand extends BaseCommand<String> {

    private final BigDecimal amount;

    public WithdrawMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(amount);
		return result;
	}

	@Override
	public String toString() {
		return "WithdrawMoneyCommand [amount=" + amount + ", getId()=" + getId() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WithdrawMoneyCommand other = (WithdrawMoneyCommand) obj;
		return Objects.equals(amount, other.amount);
	}
}
