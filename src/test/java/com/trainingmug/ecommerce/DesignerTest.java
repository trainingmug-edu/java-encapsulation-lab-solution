package com.trainingmug.ecommerce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class DesignerTest {
    @Test
    @Order(1)
    @DisplayName("Check if Designer class is present")
    public void testDesignerClassPresence() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.ecommerce.Designer");
            assertNotNull(designerClass, "Designer class should be present in the package com.trainingmug.ecommerce");
        } catch (ClassNotFoundException e) {
            fail("Class Designer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check all instance variables are private")
    public void testInstanceVariablesArePrivate() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.ecommerce.Designer");
            Field[] fields = designerClass.getDeclaredFields();
            for (Field field : fields) {
                assertTrue(Modifier.isPrivate(field.getModifiers()), "Field " + field.getName() + " should be private");
            }
        } catch (ClassNotFoundException e) {
            fail("Class Designer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Check all constructors are public")
    public void testAllConstructorsArePublic() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.ecommerce.Designer");
            Constructor<?>[] constructors = designerClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                assertTrue(Modifier.isPublic(constructor.getModifiers()), "Constructor " + constructor.getName() + " should be public");
            }
        } catch (ClassNotFoundException e) {
            fail("Class Designer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Check all methods are public")
    public void testAllMethodsArePublic() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.ecommerce.Designer");
            Method[] methods = designerClass.getDeclaredMethods();
            for (Method method : methods) {
                assertTrue(Modifier.isPublic(method.getModifiers()), "Method " + method.getName() + " should be public");
            }
        } catch (ClassNotFoundException e) {
            fail("Class Designer is not found in package com.trainingmug.ecommerce");
        }
    }

    @Test
    @Order(5)
    @DisplayName("Check if all getter and setter methods are present")
    public void testGetterAndSetterMethodsPresence() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.ecommerce.Designer");
            String[] properties = {"NoOfWebsites"};
            for (String property : properties) {
                Method getter = designerClass.getDeclaredMethod("get" + property);
                assertNotNull(getter, "Getter method for " + property + " should be present");
                Method setter = designerClass.getDeclaredMethod("set" + property, getter.getReturnType());
                assertNotNull(setter, "Setter method for " + property + " should be present");
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            fail("Required method is not found in class Designer");
        }
    }
}
