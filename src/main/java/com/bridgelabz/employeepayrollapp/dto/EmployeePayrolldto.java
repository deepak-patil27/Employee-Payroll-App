package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

@Data
public class EmployeePayrolldto {
    public String name;
    public long salary;

    public EmployeePayrolldto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrolldto{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
