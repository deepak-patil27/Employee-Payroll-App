package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrolldto;
import lombok.Data;

@Data
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int employeeId, EmployeePayrolldto empPayrolldto) {
        this.employeeId = employeeId;
        this.name = empPayrolldto.name;
        this.salary = empPayrolldto.salary;
    }
}
