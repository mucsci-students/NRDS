package com.classuml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.classuml.Model.*;
import static org.junit.jupiter.api.Assertions.*;

public class methodTest {

    private Method method;

    @BeforeEach
    public void setUp() {
        method = new Method("methodName", "void");
    }

    @Test
    public void testToString() {
        assertEquals("\n    Name: methodName,\n    Type: void,", method.toString());
    }

    @Test
    public void testGetReturnType() {
        assertEquals("void", method.getReturnType());
    }

    @Test
    public void testGetParameters() {
        assertNotNull(method.getParameters());
        assertTrue(method.getParameters().isEmpty());
    }

    @Test
    public void testDeleteAllParameters() {
        assertFalse(method.deleteAllParameters()); // Deleting when there are no parameters should return false
        method.addParameter("paramName", "int");
        assertTrue(method.deleteAllParameters()); // Deleting all parameters should return true
        assertTrue(method.getParameters().isEmpty());
    }

    @Test
    public void testChangeParameterType() {
        method.addParameter("paramName", "int");
        assertTrue(method.changeParameterType("paramName", "String"));
        assertFalse(method.changeParameterType("nonExistentParam", "String")); // Changing type of non-existent param should return false
    }
}