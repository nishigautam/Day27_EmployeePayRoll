package com.employee.payroll;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollService {
    private ArrayList<EmployeePayRollData> employeePayRollDataArrayList;

    public EmployeePayRollService(ArrayList<EmployeePayRollData> employeePayRollDataArrayList) {
        this.employeePayRollDataArrayList = employeePayRollDataArrayList;
    }

    public void readEmployeeData(Scanner inputFromConsole) {
        System.out.println("Enter Name of the Employee :");
        String name = inputFromConsole.nextLine();
        System.out.println("Enter Salary of the Employee :");
        double salary = inputFromConsole.nextDouble();
        System.out.println("Enter Employee ID :");
        int ID = inputFromConsole.nextInt();
        employeePayRollDataArrayList.add(new EmployeePayRollData(name, salary, ID));
    }

    private void writeEmployeeData() {
        System.out.println("Employee Data are :" + employeePayRollDataArrayList);
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome to Employee Payroll Service ***");
        ArrayList<EmployeePayRollData> employeePayrollList = new ArrayList<>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayrollList);
        Scanner inputFromConsole = new Scanner(System.in);
        employeePayRollService.readEmployeeData(inputFromConsole);
        employeePayRollService.writeEmployeeData();
    }
}
