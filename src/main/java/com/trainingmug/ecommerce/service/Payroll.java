package com.trainingmug.ecommerce.service;

import com.trainingmug.ecommerce.Employee;

public interface Payroll {
    void displayProfile(Employee employee);
    float calculateNetSalary(Employee employee);
    float calculateNetSalaryAfterIncrement(Employee employee);
    void displayProfile(int empId);
    void displayProfile(float fromSalaryRange,float toSalaryRange);
    void displayProfile(String department);
}
