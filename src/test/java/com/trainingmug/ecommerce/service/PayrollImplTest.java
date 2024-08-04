package com.trainingmug.ecommerce.service;

import com.trainingmug.ecommerce.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollImplTest {
    private static final Class<?> PAYROLL_IMPL_CLASS = PayrollImpl.class;
    private static final Class<?> PAYROLL_INTERFACE = Payroll.class;

    @Test
    @Order(1)
    @DisplayName("Should check if PayrollImpl class is in service package")
    public void testPayrollImplClassInServicePackage() {
        try {
            Class<?> payrollImplClass = Class.forName("com.trainingmug.ecommerce.service.PayrollImpl");
            assertNotNull(payrollImplClass, "PayrollImpl class should be present in the service package");
        } catch (ClassNotFoundException e) {
            fail("Class PayrollImpl is not found in package com.trainingmug.ecommerce.service");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Should override all methods from Payroll interface")
    public void testOverrideMethods() {
        Method[] interfaceMethods = PAYROLL_INTERFACE.getMethods();

        for (Method method : interfaceMethods) {
            try {
                Method implMethod = PAYROLL_IMPL_CLASS.getMethod(method.getName(), method.getParameterTypes());
                assertNotNull(implMethod, "Method " + method.getName() + " should be overridden in PayrollImpl");
                assertTrue(Modifier.isPublic(implMethod.getModifiers()),
                        "Method " + method.getName() + " should be public");
                assertFalse(Modifier.isAbstract(implMethod.getModifiers()),
                        "Method " + method.getName() + " should not be abstract in PayrollImpl");
            } catch (NoSuchMethodException e) {
                fail("Method " + method.getName() + " is not found in PayrollImpl or not correctly overridden");
            }
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should have methods with correct return types and parameters")
    public void testMethodSignatures() {
        checkMethodSignature("displayProfile", void.class, Employee.class);
        checkMethodSignature("calculateNetSalary", float.class, Employee.class);
        checkMethodSignature("calculateNetSalaryAfterIncrement", float.class, Employee.class);
        checkMethodSignature("displayProfile", void.class, int.class);
        checkMethodSignature("displayProfile", void.class, float.class, float.class);
        checkMethodSignature("displayProfile", void.class, String.class);
    }

    private void checkMethodSignature(String methodName, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            Method method = PAYROLL_IMPL_CLASS.getMethod(methodName, parameterTypes);
            assertEquals(returnType, method.getReturnType(),
                    "Method " + methodName + " should return " + returnType.getSimpleName());
            assertTrue(Modifier.isPublic(method.getModifiers()),
                    "Method " + methodName + " should be public");
        } catch (NoSuchMethodException e) {
            fail("Method " + methodName + " with parameters " + java.util.Arrays.toString(parameterTypes) + " is missing in PayrollImpl");
        }
    }
}
