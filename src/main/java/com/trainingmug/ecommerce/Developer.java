package com.trainingmug.ecommerce;

public class Developer extends Employee {

    private int noOfProjects;

    public Developer() {
        super();
    }

    public Developer(int empId, String name, String designation, float grossSalary, float travellingAllowances,
                     float federalTax, float stateTax, float incrementPercentage, int noOfProjects) {
        super(empId, name, designation, grossSalary, travellingAllowances, federalTax, stateTax, incrementPercentage);
        this.noOfProjects = noOfProjects;
    }

    public void displayProfile() {
        System.out.println("displayProfile() - Developer Class");
        System.out.println("Id : " + getEmpId());
        System.out.println("Name : " + getName());
        System.out.println("Designation : " + getDesignation());
        System.out.println("Gross Salary : " + getGrossSalary());
        System.out.println("Travelling Allowances : " + getTravellingAllowances());
        System.out.println("Federal Tax : " + getFederalTax());
        System.out.println("State Tax : " + getStateTax());
        System.out.println("Net Salary Increment Percentage : " + getIncrementPercentage());
        System.out.println("Net Salary : " + this.calculateNetSalary());
        System.out.println("Net Salary After Increment : " + this.calculateNetSalaryAfterIncrement());

    }

    public float calculateNetSalary() {
        System.out.println("calculateNetSalary() - Developer Class");
        return getGrossSalary() - getFederalTax() - getStateTax();
    }

    public float calculateNetSalaryAfterIncrement() {
        System.out.println("calculateNetSalaryAfterIncrement() - Developer Class");
        float netSalary;
        netSalary = calculateNetSalary();
        netSalary += (netSalary * getIncrementPercentage() / 100);
        return netSalary;
    }

    public int getNoOfProjects() {
        return noOfProjects;
    }

    public void setNoOfProjects(int noOfProjects) {
        this.noOfProjects = noOfProjects;
    }


}
