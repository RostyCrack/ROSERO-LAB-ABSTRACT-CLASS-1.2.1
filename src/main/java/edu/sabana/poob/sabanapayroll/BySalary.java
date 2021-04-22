package edu.sabana.poob.sabanapayroll;

public class BySalary extends Employee {

    private static final double TARIFA_PENSION = 0.04;
    private static final double TARIFA_SALUD = 0.04;
    private double salary;


    public BySalary(String name, String lastName, Department department, double salary, BankAccount bankAccount) {
        super(name, lastName, department, bankAccount);
        this.salary=salary;
    }

    public double getDescuentoPension(){return TARIFA_PENSION;}

    public double getDescuentoSalud(){
        return TARIFA_SALUD;
    }

    @Override
    public double calculateSalary() {
        return this.salary-((TARIFA_PENSION+TARIFA_SALUD)*this.salary) ;
    }

    @Override
    public String toString() {
        return super.toString()+", pago por salario";
    }
}
