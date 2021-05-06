package com.employee.payroll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollService {
    private ArrayList<EmployeePayRollData> employeePayRollDataArrayList;

    public EmployeePayRollService(ArrayList<EmployeePayRollData> employeePayRollDataArrayList) {
        this.employeePayRollDataArrayList = employeePayRollDataArrayList;
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
        employeePayRollDataArrayList.add(new EmployeePayRollData(name, salary, ID));
    }

    /**
     * created a write employee data method to console
     */
    void writeEmployeeData() {
        System.out.println("Employee Data are :" + employeePayRollDataArrayList);
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
        employeePayRollService.writeEmployeeData();
    }

    public int writeEmployeeDetailTofFile() throws IOException {
        int entries = 0;
        Path employeePayRollDirectory = Paths.get("testDirectory");
        File fileObj = employeePayRollDirectory.toFile();
        File[] listOfFiles = fileObj.listFiles();
        if(Files.isDirectory(employeePayRollDirectory)) {
            String newFile = employeePayRollDirectory + "/" ;
            Path newFileDirectory = Paths.get(newFile);
            Files.deleteIfExists(newFileDirectory);
            Files.createFile(newFileDirectory);
            FileWriter writer = new FileWriter(String.valueOf(newFileDirectory));
            for(EmployeePayRollData obj : employeePayRollDataArrayList) {
                writer.write("Employee ID :" + obj.ID + System.lineSeparator());
                writer.write("Employee Name :" + obj.name + System.lineSeparator());
                writer.write("Employee Salary :" + obj.salary + System.lineSeparator());
                entries = entries + 1;
            }
            writer.close();
        }
        return entries;
    }
}