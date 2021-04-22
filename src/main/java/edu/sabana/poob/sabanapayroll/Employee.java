package edu.sabana.poob.sabanapayroll;

import java.util.Objects;
import java.util.UUID;

public abstract class Employee {
    
    private UUID id;
    private String name;
    private String lastName;
    private Department department;
    private BankAccount bankAccount;

    public Employee(String name, String lastName, Department department, BankAccount bankAccount){
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.bankAccount = bankAccount;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return String.format("%s %s, department %s, salary %s", this.name, this.lastName, this.department.getName(), calculateSalary());
    }

    public UUID getId() {
        return id;
    }

    public BankAccount getBankAccount(){
        return this.bankAccount;

    }
}
