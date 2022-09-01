package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrolldto;
import com.bridgelabz.employeepayrollapp.dto.Responsedto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @Autowired

    private IEmployeePayrollService employeePayrollService;

    //localhost:8080/employeepayrollservice/get
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<Responsedto> getEmployeePayrollData() {
        List<EmployeePayrollData> employeeDataList = null;
        employeeDataList = employeePayrollService.getEmployeePayrollData();
        Responsedto responseDTO = new Responsedto("Get Call Success", employeeDataList);
        return new ResponseEntity<Responsedto>(responseDTO, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/get/1
    @GetMapping("/get/{empId}")
    public ResponseEntity<Responsedto> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        Responsedto respdto = new Responsedto("Get Call for ID Successfully", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<Responsedto> addEmployeePayrollData(@RequestBody EmployeePayrolldto employeePayrolldto) {
        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrolldto);
        Responsedto respdto = new Responsedto("Created Employee Payroll Data Successfully", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/update/1
    @PutMapping("/update/{empId}")
    public ResponseEntity<Responsedto> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrolldto employeePayrolldto) {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrolldto);
        Responsedto respdto = new Responsedto("Updated Employee Payroll Data Successfully", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/delete/1
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Responsedto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        Responsedto respdto = new Responsedto("Deleted Successfully", " Deleted Id: " + empId);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }
}
