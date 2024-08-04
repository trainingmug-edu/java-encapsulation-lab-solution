package com.trainingmug.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import com.trainingmug.ecommerce.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PayrollTest {

    @Test
    @Order(1)
    @DisplayName("Should check if service package is present")
    public void testServicePackagePresence() {
        Package servicePackage = Package.getPackage("com.trainingmug.ecommerce.service");
        assertNotNull(servicePackage, "Package com.trainingmug.ecommerce.service should be present");
    }

    @Test
    @Order(2)
    @DisplayName("Should check if Payroll interface is present with specified methods")
    public void testPayrollInterfacePresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.ecommerce.service.Payroll");
            assertTrue(payrollClass.isInterface(), "Payroll should be an interface");

            // Check if all specified methods are present
            Method[] methods = {
                    payrollClass.getMethod("displayProfile", Employee.class),
                    payrollClass.getMethod("calculateNetSalary", Employee.class),
                    payrollClass.getMethod("calculateNetSalaryAfterIncrement", Employee.class),
                    payrollClass.getMethod("displayProfile", int.class),
                    payrollClass.getMethod("displayProfile", float.class, float.class),
                    payrollClass.getMethod("displayProfile", String.class)
            };

            // Check method return types and modifiers
            for (Method method : methods) {
                assertTrue(Modifier.isPublic(method.getModifiers()), "Method " + method.getName() + " should be public");
            }

        } catch (ClassNotFoundException e) {
            fail("Interface Payroll is not found in package com.trainingmug.ecommerce.service");
        } catch (NoSuchMethodException e) {
            fail("Specified method is not found in interface Payroll: " + e.getMessage());
        }
    }
}
