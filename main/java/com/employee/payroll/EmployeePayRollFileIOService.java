package com.employee.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayRollFileIOService {
    public static String fileName = "payRollFile.txt";

    public void writeData(List<EmployeePayRollData> employeePayRollDataList) {
        StringBuffer employeeBuffer = new StringBuffer();
        employeePayRollDataList.forEach( employee -> {
            String empString = employee.toString().concat("\n");
            employeeBuffer.append(empString);
        });
        try {
            Files.write(Paths.get(fileName), employeeBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * print method for data
     * @return
     */
    public void printData() {
        try {
            Files.lines(new File("payrollFile.txt").toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File("payrollFile.txt").toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * read employee payroll
     */
    public List<EmployeePayRollData> readData() {
        List<EmployeePayRollData> list = new ArrayList<EmployeePayRollData>();
        try {
            Files.lines(new File(fileName).toPath()).map(line -> line.trim()).forEach(line -> {
                String[] data = line.split("(, )");
                String[] newData = new String[10];
                int index = 0;
                for (String d : data) {
                    String[] splitData = d.split("(=)");
                    newData[index] = splitData[1];
                    index++;
                }
                list.add(new EmployeePayRollData(newData[1], Double.parseDouble(newData[2]),
                        Integer.parseInt(newData[0])));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
