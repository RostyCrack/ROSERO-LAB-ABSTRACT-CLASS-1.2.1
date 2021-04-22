package edu.sabana.poob.sabanapayroll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SabanaPayroll {

    private HashMap<UUID, Department> departments;

    public SabanaPayroll() {
        this.departments = new HashMap<>();
    }

    public void addDepartment(Department d) {
        this.departments.put(d.getID(),d);
    }


    public void printPayroll() {
        for (UUID id : this.departments.keySet()) {
            (this.departments.get(id)).stringEmployees();
        }
    }

    public double calculateEmployeeSalary(UUID id) {
        for (UUID ids : this.departments.keySet()) {
            if ((this.departments.get(ids)).contains(id)) {
                return (this.departments.get(ids)).calculateEmployeeSalary(id);
            }
        }
        return 0;
    }

    public double calculateDepartmentSalary(UUID id) {
        double salaries = 0;
        return this.departments.get(id).getDepartmentSalary();
    }

    public double calculateUniversitySalaries() {
        double salaries = 0;
        for (UUID id : this.departments.keySet()){
            salaries += (this.departments.get(id)).getDepartmentSalary();
        }
        return salaries;
    }

    public void depositToEmployee(UUID id, double amount){
        for (UUID ids : this.departments.keySet()) {
            if ((this.departments.get(ids)).contains(id)) {
                this.departments.get(ids).depositToEmployee(id, amount);
            }
        }
    }

    public double calculateEmployeeBalance(UUID id){
        UUID containing;
        for (UUID ids : this.departments.keySet()) {
            if ((this.departments.get(ids)).contains(id)) {
                return this.departments.get(ids).calculateEmployeeBalance(id);
            }
        }
        return 0;
    }

    public double calculateAllEmployeesBalance(){
        double balance = 0;
        for (UUID id : this.departments.keySet()) {
            balance += this.departments.get(id).getDepartmentBalance();
        }
        return balance;
    }

}



