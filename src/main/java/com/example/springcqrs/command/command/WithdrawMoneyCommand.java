package com.example.springcqrs.command.command;

import java.math.BigDecimal;

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
}
