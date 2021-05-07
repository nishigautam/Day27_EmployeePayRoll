package com.employee.payroll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {

    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}

    List<EmployeePayRollData> employeePayRollList;

    public EmployeePayRollService(List<EmployeePayRollData> employeePayRollData) {
        this.employeePayRollList = employeePayRollList;
    }

    /**
     * uc1:
     * created a read employee data method from console
     * @param inputFromConsole
     */
    public void readEmployeeData(Scanner inputFromConsole) {
        System.out.println("Enter Name of the Employee :");
        String name = inputFromConsole.nextLine();
        System.out.println("Enter Salary of the Employee :");
        double salary = inputFromConsole.nextDouble();
        System.out.println("Enter Employee ID :");
        int ID = inputFromConsole.nextInt();
        employeePayRollList.add(new EmployeePayRollData(name, salary, ID));
    }

    /**
     * created a write employee data method to console
     * @param fileIo
     */
    void writeEmployeeData(IOService fileIo) {
        System.out.println("Employee Data are :" + employeePayRollList);
    }

    public void readEmployeePayRollData(Scanner inputFromConsole) {
        System.out.println("Enter Employee Id:");
        int ID = inputFromConsole.nextInt();
        System.out.println("Enter Employee Name:");
        String name = inputFromConsole.next();
        System.out.println("Enter Employee Salary :");
        double salary = inputFromConsole.nextDouble();
        employeePayRollList.add(new EmployeePayRollData(name, salary, ID));
    }

    /**
     * main method to read the above two methods
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("*** Welcome to Employee Payroll Service ***");
        ArrayList<EmployeePayRollData> employeePayrollList = new ArrayList<>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayrollList);
        Scanner inputFromConsole = new Scanner(System.in);
        employeePayRollService.readEmployeeData(inputFromConsole);
        employeePayRollService.writeEmployeeData(IOService.FILE_IO);
    }

    public long countEntries(IOService fileIo) {
        long entries = 0;
        if(fileIo.equals(IOService.FILE_IO)) {
            entries = new EmployeePayRollFileIOService().countEntries();
        }
        return entries;
    }

    public void printData(IOService fileIo) {
        if(fileIo.equals(IOService.FILE_IO)) {
            new EmployeePayRollFileIOService().printData();
        }
    }
}