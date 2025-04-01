package com.gentech.employee.mapper;

import com.gentech.employee.dto.EmployeeDto;
import com.gentech.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getJobName(),
                employee.getSalary(),
                employee.getCityName(),
                employee.getCountryName(),
                employee.getCreatedDate(),
                employee.getModifiedDate()
        );
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto)
    {
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getJobName(),
                employeeDto.getSalary(),
                employeeDto.getCityName(),
                employeeDto.getCountryName(),
                employeeDto.getCreatedDate(),
                employeeDto.getModifiedDate()
        );
        return employee;
    }
}
