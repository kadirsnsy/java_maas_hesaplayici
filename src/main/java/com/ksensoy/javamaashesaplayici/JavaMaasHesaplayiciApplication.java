package com.ksensoy.javamaashesaplayici;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ksensoy.javamaashesaplayici.Dto.EmployeeDto;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaMaasHesaplayiciApplication {
    protected static Logger logger = Logger.getLogger(JavaMaasHesaplayiciApplication.class);

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(JavaMaasHesaplayiciApplication.class, args);
        Employee employee = new Employee();
        employee.setName("Kadir ŞENSOY");
        employee.setSalary(2000);
        employee.setWorkHours(45);
        employee.setHireYear(1985);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(employee);
        logger.info("EmployeeDto json: " + json);


        Employee employee1 = new Employee();
        employee1.setName("Kadir ŞENSOY_2");
        employee1.setSalary(2000);
        employee1.setWorkHours(28);
        employee1.setHireYear(2005);

        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json1 = ow.writeValueAsString(employee1);
        logger.info("EmployeeDto json: " + json1);

    }

}
