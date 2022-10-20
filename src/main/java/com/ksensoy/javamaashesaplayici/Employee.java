package com.ksensoy.javamaashesaplayici;

import lombok.Data;

import java.util.logging.Logger;

@Data
public class Employee {
    protected static Logger logger = Logger.getLogger(String.valueOf(Employee.class));
    private String name;
    private float salary;
    private Integer workHours;
    private Integer hireYear;

    private float tax;
    private float bonus;
    private float raiseSalary;
    private float salaryWithTaxAndBonus;
    private float totalSalary;

    //tax() fonksiyonu ile sadece salary’i uygulanan vergi hesaplanacak
    public float getTax() {
        tax=percentCalculate(salary,tax());
        return tax;
    }

    public float getBonus() {
        bonus=bonus();
        return bonus;
    }

    //raiseSalary() hesaplarken vergi ve bonusları dikkate almalısınız.
    public float getRaiseSalary() {
        raiseSalary=percentCalculate(salary,raiseSalary());
        return raiseSalary;
    }

    //Vergi ve bonuslarla birlikte maaş için: vergi, bonus ve çalışanın kendi maaşı ile bulunacak.
    public float getSalaryWithTaxAndBonus() {
        salaryWithTaxAndBonus=getSalary()+bonus-tax;
        return salaryWithTaxAndBonus;
    }

    //Toplam maaş: çalışanın kendi maaşı +artış+ bonus
    public float getTotalSalary() {
        totalSalary= salary+bonus-tax+raiseSalary;
        return totalSalary ;
    }


    private  Integer tax(){
        Integer percentTax=0;

        if (salary<1000)
        {
            percentTax=0;
        }
        else {
            percentTax=3;
        }
        logger.info("Vergi yüzdeliği:  %"+percentTax);
        return  percentTax;
    }
    private  Integer bonus(){
        Integer bonus=0;

        if (workHours>40)
        {
            bonus=  30*(workHours-40);
            logger.info("Bonuslu gün sayısı: "+(workHours-40));
        }
        else {
            logger.info("Bonuslu gün sayısı yok");
        }


        return  bonus;
    }
    private  Integer raiseSalary(){
        Integer percentRaise=0;
        Integer differenceYear=2021-hireYear;

        if (differenceYear<10)
        {
            percentRaise=5;
        }
        else if(differenceYear<20)
        {
            percentRaise=10;
        }
        else {
            percentRaise=15;
        }
        logger.info("Çalışma yıl yüzdeliği:  %"+percentRaise);

        return  percentRaise;
    }

    private  float percentCalculate(float salary, Integer percent){
        float result= (salary*percent)/100;
        return  result;
    }

}
