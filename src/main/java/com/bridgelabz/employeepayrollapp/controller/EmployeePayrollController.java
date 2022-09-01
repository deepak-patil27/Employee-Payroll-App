package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrolldto;
import com.bridgelabz.employeepayrollapp.dto.Responsedto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    //localhost:8080/employeepayrollservice/get
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<Responsedto> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrolldto("Deepak", 200000));
        Responsedto responsedto = new Responsedto("Get Call Success", employeePayrollData);
        return new ResponseEntity<Responsedto>(responsedto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/get/1
    @GetMapping("/get/{empId}")
    public ResponseEntity<Responsedto> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrolldto("Deepak", 200000));
        Responsedto respdto = new Responsedto("Get Call for ID Successfully", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<Responsedto> addEmployeePayrollData(@RequestBody EmployeePayrolldto employeePayrolldto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrolldto);
        Responsedto respdto = new Responsedto("Created Employee Payroll Data Successfully", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/update/1
    @PutMapping("/update/{empId}")
    public ResponseEntity<Responsedto> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrolldto employeePayrolldto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, employeePayrolldto);
        Responsedto respdto = new Responsedto("Updated Employee Payroll Data Successfully", employeePayrollData);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }

    //localhost:8080/employeepayrollservice/delete/1
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Responsedto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        Responsedto respdto = new Responsedto("Deleted Successfully", " Deleted Id: " + empId);
        return new ResponseEntity<Responsedto>(respdto, HttpStatus.OK);
    }
}
