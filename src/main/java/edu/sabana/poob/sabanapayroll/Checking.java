package edu.sabana.poob.sabanapayroll;

import java.time.LocalDate;

public class Checking extends BankAccount {

    public Checking(){
        super();
    }

    @Override
    public double getDepositDiscount() {
        return 5000;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningñun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */
    public boolean processCheck(Check check){
        if (check.getExpirationDate().isAfter(LocalDate.now()) && check.getAmount()>this.getDepositDiscount()) {
            this.deposit(check.getAmount());
            return true;
        }
        else {
            return false;
        }
    }

}
