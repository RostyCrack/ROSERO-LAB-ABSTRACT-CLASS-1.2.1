package edu.sabana.poob.sabanapayroll;

public class Savings extends BankAccount {

    private static final double ANNUAL_INTEREST_RATE = 0.01;

    public Savings(){
        super();
    }

    @Override
    public double getDepositDiscount() {
        return 2000;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningñun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */
    public double depositMontlyInterest(){
        double MONTHLY_RATE = ANNUAL_INTEREST_RATE/12;
        double amount = MONTHLY_RATE * getBalance();
        this.deposit(this.getDepositDiscount()+amount);
        return amount;
    }

}
