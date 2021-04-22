package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private static ByHours e1;
    private static ByComision e2;
    private static BySalary e3;

    private static SabanaPayroll sabanaPayroll;

    private static Department VENTAS;
    private static Department FINANZAS;
    private static Department INGENIERIA;

    private static BankAccount savings;
    private static BankAccount checkings;
    private static BankAccount savings2;


    @BeforeAll
    public static void setUp(){

        sabanaPayroll = new SabanaPayroll();

        VENTAS = new Department("VENTAS");
        FINANZAS = new Department("FINANZAS");
        INGENIERIA = new Department("INGERNIERIA");

        savings = new Savings();
        savings2 = new Savings();
        checkings = new Checking();

        sabanaPayroll.addDepartment(VENTAS);
        sabanaPayroll.addDepartment(FINANZAS);
        sabanaPayroll.addDepartment(INGENIERIA);


        e1 = new ByHours("Justin", "Bieber", VENTAS, 78, savings);
        e2 = new ByComision("Maluma", ":v", FINANZAS, 6389, checkings);
        e3 = new BySalary("J", "Balvin", INGENIERIA, 5000, savings2);

        VENTAS.addEmployee(e1);
        FINANZAS.addEmployee(e2);
        INGENIERIA.addEmployee(e3);







    }

    @Test
    public void calculateEmployeeSalary(){
        assertEquals(351, sabanaPayroll.calculateEmployeeSalary(e1.getId()));
        assertEquals(25556, sabanaPayroll.calculateEmployeeSalary(e2.getId()));
        assertEquals(4600.0, sabanaPayroll.calculateEmployeeSalary(e3.getId()));

    }

    @Test
    public void calculateDepartmentSalary(){
        assertEquals(351, sabanaPayroll.calculateDepartmentSalary(VENTAS.getID()));
        assertEquals(25556, sabanaPayroll.calculateDepartmentSalary(FINANZAS.getID()));
        assertEquals(4600, (int) sabanaPayroll.calculateDepartmentSalary(INGENIERIA.getID()));
    }


    @Test
    public void universitySalary(){
        assertEquals(30507, (int) sabanaPayroll.calculateUniversitySalaries());
        sabanaPayroll.printPayroll();
    }

    @Test
    public void depositToEmployee(){
        sabanaPayroll.depositToEmployee(e1.getId(), 10000);
        assertEquals(8000, savings.getBalance());
        sabanaPayroll.depositToEmployee(e2.getId(), 10000);
        assertEquals(5000, checkings.getBalance());
        sabanaPayroll.depositToEmployee(e3.getId(), 12000);
        assertEquals(10000, savings2.getBalance());
    }




}
