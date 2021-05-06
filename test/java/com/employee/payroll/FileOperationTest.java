package com.employee.payroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperationTest {

    @Test
    public void entriesShouldReturnNoEntriesSentToFile() throws IOException {
        ArrayList<EmployeePayRollData> employeePayRollDataArrayList = new ArrayList<>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollDataArrayList);
        Scanner inputFromConsole = new Scanner(System.in);
        employeePayRollService.readEmployeeData(inputFromConsole);
        employeePayRollService.writeEmployeeData();
        int count = employeePayRollService.writeEmployeeDetailTofFile();
        Assertions.assertEquals(1, count);
    }
}
