package com.trainingmug.ecommerce.service;

import com.trainingmug.ecommerce.Employee;

public class PayrollImpl implements Payroll {

    @Override
    public void displayProfile(Employee employee) {
        employee.displayProfile();
    }

    @Override
    public float calculateNetSalary(Employee employee) {
        return employee.calculateNetSalary();

    }

    @Override
    public float calculateNetSalaryAfterIncrement(Employee employee) {
        return employee.calculateNetSalaryAfterIncrement();
    }

    @Override
    public void displayProfile(int empId) {
        System.out.println("This method display the employee profile with Employee ID");
    }

    @Override
    public void displayProfile(float fromSalaryRange, float toSalaryRange) {
        System.out.println("This method display all employee profiles from and to given salary ranges");
    }

    @Override
    public void displayProfile(String department) {
        System.out.println("This method display all the employee profiles from a given department");
    }
}