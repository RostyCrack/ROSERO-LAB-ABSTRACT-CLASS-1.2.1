package edu.sabana.poob.sabanapayroll;

import java.util.*;

public class Department{

    private UUID id;
    private String name;
    private HashMap <UUID, Employee> employees;

    public Department(String name) {
        this.employees = new HashMap<>();
        this.id = UUID.randomUUID();
        this.name = name;

    }


    public void addEmployee(Employee e){
        this.employees.put(e.getId(), e);
    }

    public String getName(){
        return this.name;
    }

    public boolean contains(UUID id) {
        return this.employees.containsKey(id);
    }

    public double calculateEmployeeSalary(UUID id) {
        return this.employees.get(id).calculateSalary();
    }


    public void stringEmployees(){
        for (UUID id: employees.keySet()){
            System.out.println((employees.get(id)).toString());
        }
    }

    public double getDepartmentSalary() {
        double salary = 0;
        for (UUID id: employees.keySet()){
            salary += (employees.get(id)).calculateSalary();
        }
        return salary;
    }


    public UUID getID() {
        return this.id;
    }

    public void depositToEmployee(UUID id, Double amount) {
        (this.employees.get(id).getBankAccount()).deposit(amount);
    }

    public double calculateEmployeeBalance(UUID id) {
        return this.employees.get(id).getBankAccount().getBalance();
    }

    public double getDepartmentBalance() {
        double balance = 0;
        for (UUID id : this.employees.keySet()) {
            balance += this.employees.get(id).getBankAccount().getBalance();
        }
        return balance;
    }
}
