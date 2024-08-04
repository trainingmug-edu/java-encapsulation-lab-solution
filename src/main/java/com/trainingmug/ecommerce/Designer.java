package com.trainingmug.ecommerce;

public class Designer extends Employee {

    private int noOfWebsites;

    public Designer() {
        super();
    }

    public Designer(int empId, String name, String designation, float grossSalary, float travellingAllowances,
                    float federalTax, float stateTax, float incrementPercentage, int noOfWebsites) {
        super(empId, name, designation, grossSalary, travellingAllowances, federalTax, stateTax, incrementPercentage);
        this.noOfWebsites = noOfWebsites;
    }

    public void displayProfile() {
        System.out.println("displayProfile() - Designer Class");
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
        System.out.println("calculateNetSalary() - Designer Class");
        return getGrossSalary() - getFederalTax() - getStateTax();
    }

    public float calculateNetSalaryAfterIncrement() {
        System.out.println("calculateNetSalaryAfterIncrement() - Designer Class");
        float netSalary;
        netSalary = calculateNetSalary();
        netSalary += (netSalary * getIncrementPercentage() / 100);
        return netSalary;
    }

    public int getNoOfWebsites() {
        return noOfWebsites;
    }

    public void setNoOfWebsites(int noOfWebsites) {
        this.noOfWebsites = noOfWebsites;
    }



}
