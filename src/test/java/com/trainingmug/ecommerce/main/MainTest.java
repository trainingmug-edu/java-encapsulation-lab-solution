package com.trainingmug.ecommerce.main;

import com.trainingmug.ecommerce.Designer;
import com.trainingmug.ecommerce.Developer;
import com.trainingmug.ecommerce.Employee;
import com.trainingmug.ecommerce.service.PayrollImpl;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    @Order(1)
    @DisplayName("Should check if Main class is in main package")
    public void testMainClassInMainPackage() {
        try {
            Class<?> mainClass = Class.forName("com.trainingmug.ecommerce.main.Main");
            assertNotNull(mainClass, "Main class should be present in the main package");
        } catch (ClassNotFoundException e) {
            fail("Class Main is not found in package com.digisafari.main");
        }
    }


    private static PayrollImpl payroll;
    private static Developer developer1, developer2;
    private static Designer designer1, designer2;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setup() {
        developer1 = new Developer(5555, "David Austin", "Senior Backend Developer", 6579.45F, 332.5F, 629.45F, 398.34F, 9.5F, 5);
        developer2 = new Developer(6666, "Nancy Greenberg", "Junior Backend Developer", 4369.45F, 278.5F, 529.45F, 318.34F, 12.5F, 3);
        designer1 = new Designer(7777, "Daniel Faviet", "Senior UI/UX Designer", 6349.45F, 322.5F, 618.45F, 387.34F, 8.5F, 5);
        designer2 = new Designer(8888, "Daniel Faviet", "Junior UI/UX Designer", 4339.45F, 277.5F, 526.45F, 316.34F, 12.8F, 3);
        payroll = new PayrollImpl();

        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @Order(1)
    @DisplayName("Should create PayrollImpl object in Main class")
    public void testPayrollImplCreation() {
        assertNotNull(payroll, "PayrollImpl object should be created");
    }


    @Test
    @Order(2)
    @DisplayName("Should invoke all PayrollImpl methods correctly")
    public void testPayrollImplMethodsInvocation() {
        try {
            // Create instances of Developer and Designer
            Developer developer1 = new Developer(5555, "David Austin", "Senior Backend Developer", 6579.45F, 332.5F, 629.45F, 398.34F, 9.5F, 5);
            Developer developer2 = new Developer(6666, "Nancy Greenberg", "Junior Backend Developer", 4369.45F, 278.5F, 529.45F, 318.34F, 12.5F, 3);
            Designer designer1 = new Designer(7777, "Daniel Faviet", "Senior UI/UX Designer", 6349.45F, 322.5F, 618.45F, 387.34F, 8.5F, 5);
            Designer designer2 = new Designer(8888, "Daniel Faviet", "Junior UI/UX Designer", 4339.45F, 277.5F, 526.45F, 316.34F, 12.8F, 3);

            PayrollImpl payroll = new PayrollImpl();

            // List of methods to be invoked
            List<Method> methods = Arrays.asList(
                    payroll.getClass().getMethod("calculateNetSalary", Employee.class),
                    payroll.getClass().getMethod("calculateNetSalaryAfterIncrement", Employee.class),
                    payroll.getClass().getMethod("displayProfile", Employee.class)
            );

            // Invoke methods with Developer and Designer instances
            for (Method method : methods) {
                method.invoke(payroll, developer1);
                method.invoke(payroll, developer2);
                method.invoke(payroll, designer1);
                method.invoke(payroll, designer2);
            }

            // Check if methods were correctly invoked
            assertAll(
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalary(developer1), "Method calculateNetSalary should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalary(developer2), "Method calculateNetSalary should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalary(designer1), "Method calculateNetSalary should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalary(designer2), "Method calculateNetSalary should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalaryAfterIncrement(developer1), "Method calculateNetSalaryAfterIncrement should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalaryAfterIncrement(developer2), "Method calculateNetSalaryAfterIncrement should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalaryAfterIncrement(designer1), "Method calculateNetSalaryAfterIncrement should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.calculateNetSalaryAfterIncrement(designer2), "Method calculateNetSalaryAfterIncrement should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.displayProfile(developer1), "Method displayProfile should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.displayProfile(developer2), "Method displayProfile should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.displayProfile(designer1), "Method displayProfile should be invoked without exception"),
                    () -> assertDoesNotThrow(() -> payroll.displayProfile(designer2), "Method displayProfile should be invoked without exception")
            );

        } catch (Exception e) {
            fail("Exception occurred while testing PayrollImpl methods invocation in Main class: " + e.getMessage());
        }
    }

}
