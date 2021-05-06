package com.employee.payroll;

public class EmployeePayRollData {
    public String name;
    public double salary;
    public int ID;

    public EmployeePayRollData(String name, double salary, int ID) {
        this.name = name;
        this.salary = salary;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "EmployeePayRollData[" + "Name=" + name + ", Salary=" + salary +
        ", ID=" + ID + "]";
    }
}
