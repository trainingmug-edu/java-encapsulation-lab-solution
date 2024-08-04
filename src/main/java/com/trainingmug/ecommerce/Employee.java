package com.trainingmug.ecommerce;

public class Employee {
// Instance Variables

    private int empId;
    private String name;
    private String designation;
    private float grossSalary;
    private float travellingAllowances;
    private float federalTax;
    private float stateTax;
    private float incrementPercentage;


    private static String companyName = "Digi-Safari Pvt Ltd";
    private static String companyContactNo = "+1 678-505-0990";
    private static int employeeCount = 0;


    public Employee() {
        employeeCount++;
    }

    public Employee(int empId, String name, String designation, float grossSalary, float travellingAllowances,
                    float federalTax, float stateTax, float incrementPercentage) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.grossSalary = grossSalary;
        this.travellingAllowances = travellingAllowances;
        this.federalTax = federalTax;
        this.stateTax = stateTax;
        this.incrementPercentage = incrementPercentage;
        employeeCount++;
    }

    public void displayProfile() {
        System.out.println("displayProfile() - Employee Class");
        System.out.println("Id : " + empId);
        System.out.println("Name : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Gross Salary : " + grossSalary);
        System.out.println("Travelling Allowances : " + travellingAllowances);
        System.out.println("Federal Tax : " + federalTax);
        System.out.println("State Tax : " + stateTax);
        System.out.println("Net Salary Increment Percentage : " + incrementPercentage);
        System.out.println("Net Salary : " + this.calculateNetSalary());
        System.out.println("Net Salary After Increment : " + this.calculateNetSalaryAfterIncrement());

    }

    public static void displayCompanyInfo() {
        System.out.println("Company Name : " + companyName);
        System.out.println("Company Contact No : " + companyContactNo);
        System.out.println("Employee Count : " + employeeCount);
    }

    public float calculateNetSalary() {
        System.out.println("calculateNetSalary() - Employee Class");
        return grossSalary - federalTax - stateTax;
    }

    public float calculateNetSalaryAfterIncrement() {
        System.out.println("calculateNetSalaryAfterIncrement() - Employee Class");
        float netSalary;
        netSalary = calculateNetSalary();
        netSalary += (netSalary * incrementPercentage / 100);
        return netSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
    }

    public float getTravellingAllowances() {
        return travellingAllowances;
    }

    public void setTravellingAllowances(float travellingAllowances) {
        this.travellingAllowances = travellingAllowances;
    }

    public float getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(float federalTax) {
        this.federalTax = federalTax;
    }

    public float getStateTax() {
        return stateTax;
    }

    public void setStateTax(float stateTax) {
        this.stateTax = stateTax;
    }

    public float getIncrementPercentage() {
        return incrementPercentage;
    }

    public void setIncrementPercentage(float incrementPercentage) {
        this.incrementPercentage = incrementPercentage;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }

    public static String getCompanyContactNo() {
        return companyContactNo;
    }

    public static void setCompanyContactNo(String companyContactNo) {
        Employee.companyContactNo = companyContactNo;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }



}
