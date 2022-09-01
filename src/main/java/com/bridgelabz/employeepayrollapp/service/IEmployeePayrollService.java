package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrolldto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import java.util.List;
public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrolldto empPayrolldto);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrolldto empPayrolldto);

    void deleteEmployeePayrollData(int empId);

}
