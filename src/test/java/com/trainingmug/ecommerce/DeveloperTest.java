package com.trainingmug.ecommerce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {
    @Test
    @Order(1)
    @DisplayName("Check if Developer class is present")
    public void testDeveloperClassPresence() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.ecommerce.Developer");
            assertNotNull(developerClass, "Developer class should be present in the package com.trainingmug.ecommerce");
        } catch (ClassNotFoundException e) {
            fail("Class Developer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check all instance variables are private")
    public void testInstanceVariablesArePrivate() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.ecommerce.Developer");
            Field[] fields = developerClass.getDeclaredFields();
            for (Field field : fields) {
                assertTrue(Modifier.isPrivate(field.getModifiers()), "Field " + field.getName() + " should be private");
            }
        } catch (ClassNotFoundException e) {
            fail("Class Developer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Check all constructors are public")
    public void testAllConstructorsArePublic() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.ecommerce.Developer");
            Constructor<?>[] constructors = developerClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                assertTrue(Modifier.isPublic(constructor.getModifiers()), "Constructor " + constructor.getName() + " should be public");
            }
        } catch (ClassNotFoundException e) {
            fail("Class Developer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Check all methods are public")
    public void testAllMethodsArePublic() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.ecommerce.Developer");
            Method[] methods = developerClass.getDeclaredMethods();
            for (Method method : methods) {
                assertTrue(Modifier.isPublic(method.getModifiers()), "Method " + method.getName() + " should be public");
            }
        } catch (ClassNotFoundException e) {
            fail("Class Developer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(5)
    @DisplayName("Check if all getter and setter methods are present")
    public void testGetterAndSetterMethodsPresence() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.ecommerce.Developer");
            String[] properties = {"NoOfProjects"};
            for (String property : properties) {
                Method getter = developerClass.getDeclaredMethod("get" + property);
                assertNotNull(getter, "Getter method for " + property + " should be present");
                Method setter = developerClass.getDeclaredMethod("set" + property, getter.getReturnType());
                assertNotNull(setter, "Setter method for " + property + " should be present");
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            fail("Required method is not found in class Developer");
        }
    }
}
