package com.gentech.employee.service;

import com.gentech.employee.dto.EmployeeDto;
import com.gentech.employee.entity.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    EmployeeDto modifyEmployee(Long id,EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByName(String name);
    List<EmployeeDto> getEmployeesByCityNameAndCountryName(String city,String country);

    List<EmployeeDto> getEmployeesBySalary(Integer salary);

    List<EmployeeDto> getEmployeesByJobNameKeyword(String jobkeyword, String columnName);

    List<EmployeeDto> getAllEmployees(Integer pageNumber, Integer pageSize);

    List<EmployeeDto> getEmployeesByJobNameOrCountryName(String jobName, String countryName);

    Integer deleteEmployeesByCityName(String cityName);

    Integer updateEmployeesByJobName(String countryName,String jobName);
}
