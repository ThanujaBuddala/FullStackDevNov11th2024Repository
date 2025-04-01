package com.gentech.employee.controller;

import com.gentech.employee.dto.EmployeeDto;
import com.gentech.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(service.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id)
    {
        return new ResponseEntity<>(service.getEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> modifyEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(service.modifyEmployee(id, employeeDto), HttpStatus.OK);
    }

    @GetMapping("/employee/filterbyname")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeByName(@RequestParam String name)
    {
        return new ResponseEntity<>(service.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employee/filterbycityandcountry")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesByCityAndfCountry(
            @RequestParam String city,@RequestParam String country
    )
    {
        List<EmployeeDto> employees=service.getEmployeesByCityNameAndCountryName(city,country);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/filterbysalary/{salary}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesBySalary(@PathVariable Integer salary)
    {
        List<EmployeeDto> employees=service.getEmployeesBySalary(15000);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/jobkeyword")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByJobKeyword(@RequestParam String jobkeyword,
                                                                        @RequestParam String columnName)
    {
        return new ResponseEntity<>(service.getEmployeesByJobNameKeyword(jobkeyword,columnName),HttpStatus.OK);
    }

    @GetMapping("/employee/pagination")
    public ResponseEntity<List<EmployeeDto>> getAllEmployes(@RequestParam Integer pageNumber,
                                                            @RequestParam Integer pageSize)
    {
        List<EmployeeDto> employees=service.getAllEmployees(pageNumber, pageSize);
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/filterjoborcountry")
    public ResponseEntity<List<EmployeeDto>> getEmployeesUsingJobOrCountry(
          @RequestParam String jobName,@RequestParam String countryName
    )
    {
        List<EmployeeDto> employees=service.getEmployeesByJobNameOrCountryName(jobName,countryName);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/employee/deletebycity")
    public ResponseEntity<String> deleteEmployeesByCity(@RequestParam String cityName)
    {
        Integer count=service.deleteEmployeesByCityName(cityName);
        return new ResponseEntity<>(count+" employees records have affected by delete operation", HttpStatus.OK);
    }

    @PutMapping("/employee/updatebyjob")
    public ResponseEntity<String> updateEmployeesByJob(@RequestParam String countryName,
                                                       @RequestParam String jobName)
    {
        Integer count=service.updateEmployeesByJobName(countryName,jobName);
        return new ResponseEntity<>(count+" Employees records have updated by JobName filter condition!!!", HttpStatus.OK);
    }
}
