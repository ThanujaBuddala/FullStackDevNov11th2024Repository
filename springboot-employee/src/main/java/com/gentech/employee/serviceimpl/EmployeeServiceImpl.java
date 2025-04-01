package com.gentech.employee.serviceimpl;

import com.gentech.employee.dto.EmployeeDto;
import com.gentech.employee.entity.Employee;
import com.gentech.employee.mapper.EmployeeMapper;
import com.gentech.employee.repository.EmployeeRepository;
import com.gentech.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=repository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee=repository.findById(id).orElseThrow(() ->
                new RuntimeException("The Employee With id "+id+" has not found in the database!!!"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto modifyEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee=repository.findById(id).orElseThrow(() ->
                new RuntimeException("The Employee With id "+id+" has not found in the database!!!"));

        employee.setName(employeeDto.getName());
        employee.setJobName(employeeDto.getJobName());
        employee.setSalary(employeeDto.getSalary());
        employee.setCityName(employeeDto.getCityName());
        employee.setCountryName(employeeDto.getCountryName());

        Employee savedEmploee=repository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmploee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByName(String name) {
        return repository.findByName(name).stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByCityNameAndCountryName(String city, String country) {
        return repository.findByCityNameAndCountryName(city, country).stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesBySalary(Integer salary) {
        return repository.findBySalary(salary).stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByJobNameKeyword(String jobkeyword, String columnName) {
        Sort sort=Sort.by(Sort.Direction.DESC, columnName);
        return repository.findByJobNameContaining(jobkeyword, sort).stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getAllEmployees(Integer pageNumber, Integer pageSize) {
        Pageable pages= PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id" );
        return repository.findAll(pages).getContent().stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByJobNameOrCountryName(String jobname, String countryName) {
        return repository.getEmployeesByJobNameOrCountryName(jobname,countryName).stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public Integer deleteEmployeesByCityName(String cityName) {

        return repository.deleteEmployeesByCityName(cityName);
    }

    @Override
    public Integer updateEmployeesByJobName(String countryName, String jobName) {
        return repository.updateEmployeesByJobName(countryName,jobName);
    }

}

