package com.ksensoy.javamaashesaplayici.Dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private Integer salary;
    private Integer workHours;
    private Integer hireYear;

    private Integer tax;
    private Integer bonus;
    private Integer raiseSalary;
    private Integer salaryWithTaxAndBonus;
    private Integer totalSalary;


}


