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

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    List<EmployeePayRollData> employeePayRollList;

    public EmployeePayRollService(List<EmployeePayRollData> employeePayRollData) {
        this.employeePayRollList = employeePayRollList;
    }

    public static Scanner inputFromConsole = new Scanner(System.in);

    /**
     * uc1:
     * created a read employee data method from console
     *
     * @param ioService
     */
    public void readEmployeeData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("Enter Name of the Employee :");
            String name = inputFromConsole.nextLine();
            System.out.println("Enter Salary of the Employee :");
            double salary = inputFromConsole.nextDouble();
            System.out.println("Enter Employee ID :");
            int ID = inputFromConsole.nextInt();
            employeePayRollList.add(new EmployeePayRollData(name, salary, ID));
        } else if (ioService.equals(IOService.FILE_IO)) {
            System.out.println("Reading Data..");
            new EmployeePayRollFileIOService().printData();
        }
    }
    /**
     * created a write employee data method to console
     * @param ioService
     */
    void writeEmployeeData(IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Writing Employee PayRoll Data to console :" + employeePayRollList);
        else if(ioService.equals(IOService.FILE_IO))
            new EmployeePayRollFileIOService().writeData(employeePayRollList);
    }


    /**
     * main method to read the above two methods
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("*** Welcome to Employee Payroll Service ***");
        List<EmployeePayRollData> employeePayRollDataList = new ArrayList<>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollDataList);

        employeePayRollService.readEmployeeData(IOService.FILE_IO);
        employeePayRollService.writeEmployeeData(IOService.CONSOLE_IO);
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