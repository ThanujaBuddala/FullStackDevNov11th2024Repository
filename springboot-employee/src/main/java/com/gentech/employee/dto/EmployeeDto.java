package com.gentech.employee.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private String jobName;
    private Integer salary;
    private String cityName;
    private String countryName;
    private Date createdDate;
    private Date modifiedDate;


}
