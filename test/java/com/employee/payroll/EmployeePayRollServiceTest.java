package com.employee.payroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class EmployeePayRollServiceTest {

    @Test
    public void givenEntriesShouldReturnMatchedEntriesSentToFile() throws IOException {
        EmployeePayRollData[] arrOfEmployees = {
                new EmployeePayRollData("Joe", 30000, 123),
                new EmployeePayRollData("Alex", 45000, 231),
                new EmployeePayRollData("Lana", 50000, 213),
        };
        EmployeePayRollService employeePayRollService;
        employeePayRollService = new EmployeePayRollService(Arrays.asList(arrOfEmployees));
        employeePayRollService.writeEmployeeData(EmployeePayRollService.IOService.FILE_IO);
        employeePayRollService.printData(EmployeePayRollService.IOService.FILE_IO);
        long entries = employeePayRollService.countEntries(EmployeePayRollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entries);
    }
}
