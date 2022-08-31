package com.bridgelabz.employeepayrollapp.controller.dto;

public class EmployeePayrolldto {
    public String name;
    public long salary;

    public EmployeePayrolldto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
