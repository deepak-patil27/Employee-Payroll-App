package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.controller.dto.EmployeePayrolldto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    //localhost:8080/employeepayrollservice
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/get/{empId}
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId")int empId){
        return new ResponseEntity<String>("Get Call Success for id: " +empId,HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrolldto employeePayrolldto){
        return new ResponseEntity<String>("Created Employee Payroll Data for: " +employeePayrolldto,HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/update
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrolldto employeePayrolldto){
        return new ResponseEntity<String>("Upated Employee Payroll Data for: " +employeePayrolldto,HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/delete/{empId}
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId")int empId){
        return new ResponseEntity<String>("Delete Call Success for id: " +empId, HttpStatus.OK);
    }
}
