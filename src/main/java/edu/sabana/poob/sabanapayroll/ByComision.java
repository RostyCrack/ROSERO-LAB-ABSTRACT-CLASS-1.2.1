package edu.sabana.poob.sabanapayroll;

public class ByComision extends Employee{

    private int soldProducts;
    private static final double COMISION = 4 ;

    public ByComision(String name, String lastName, Department department, int soldProducts, BankAccount bankAccount) {
        super(name, lastName, department, bankAccount);
        this.soldProducts=soldProducts;
    }


    @Override
    public double calculateSalary() {
        return this.soldProducts*COMISION;
    }

    @Override
    public String toString() {
        return super.toString()+", pago por comision.";
    }
}



