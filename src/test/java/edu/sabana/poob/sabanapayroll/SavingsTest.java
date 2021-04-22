package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavingsTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();

        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }

    @Test
    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(10000);

        assertTrue(result);
        assertTrue(Double.compare(8000, account.getBalance()) == 0);
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(2000));
        assertFalse(account.deposit(1000));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }

    @Test
    public void shouldKeepBalance() {
        Savings account = new Savings();

        assertTrue(account.deposit(11000)); //9000
        assertFalse(account.deposit(2000));
        assertTrue(account.deposit(5000)); //3000
        assertTrue(account.deposit(21000)); //19000
        //31000
        account.Withdraw(6000); //24976
        account.Withdraw(4000); //20960

        assertTrue(Double.compare(20960, account.getBalance()) == 0);
    }
}
