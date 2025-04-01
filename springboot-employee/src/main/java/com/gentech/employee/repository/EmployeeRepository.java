package com.gentech.employee.repository;

import com.gentech.employee.entity.Employee;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByCityNameAndCountryName(String cityname,String countryname);

    List<Employee> findBySalary(Integer salary);

    List<Employee> findByJobNameContaining(String keyword, Sort sort);

    @Query("FROM Employee WHERE jobName=:job OR countryName=:country")
    List<Employee> getEmployeesByJobNameOrCountryName(@Param("job") String jobName,@Param("country") String countryName);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Employee WHERE cityName=:city")
    Integer deleteEmployeesByCityName(@Param("city") String city);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Employee SET countryName=:country WHERE jobName=:job")
    Integer updateEmployeesByJobName(@Param("country") String country,@Param("job") String job);
}