package com.gentech.employee.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_job")
    private String jobName;
    @Column(name = "employee_salary")
    private Integer salary;
    @Column(name = "employee_cityname")
    private String cityName;
    @Column(name = "employee_countryname")
    private String countryName;

    @Column(name = "created_date", nullable = false,updatable = false)
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "modified_date", nullable = false, updatable = true)
    @UpdateTimestamp
    private Date modifiedDate;
}
