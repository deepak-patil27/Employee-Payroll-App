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
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        Responsedto respdto = new Responsedto("Get call Success", employeePayrollDataList);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }
    //localhost:8080/employeepayrollservice/get/1
    @GetMapping("/get/{empId}")
    public ResponseEntity<Responsedto> getEmployeePayrollData(@PathVariable(value = "empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData=employeePayrollService.getEmployeePayrollDataById(empId);
        Responsedto respdto = new Responsedto("Get Call Success for Id successful ", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }
    //localhost:8080/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<Responsedto> addEmployeePayrollData(@RequestBody EmployeePayrolldto empPayrolldto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrolldto);
        Responsedto responsedto = new Responsedto("Created employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<>(responsedto, HttpStatus.OK);
    }
    //localhost:8080/employeepayrollservice/update/2
    @PutMapping("/update/{empId}")
    public ResponseEntity<Responsedto> updateEmployeePayrollData(@PathVariable int empId,@RequestBody EmployeePayrolldto empPayrolldto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId,empPayrolldto);
        Responsedto responsedto = new Responsedto("Updated employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<>(responsedto, HttpStatus.OK);
    }
    //localhost:8080/employeepayrollservice/delete/1
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Responsedto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        Responsedto responsedto = new Responsedto("Deleted successfully","Deleted id: "+empId);
        return new  ResponseEntity<>(responsedto,HttpStatus.OK);
    }
}
