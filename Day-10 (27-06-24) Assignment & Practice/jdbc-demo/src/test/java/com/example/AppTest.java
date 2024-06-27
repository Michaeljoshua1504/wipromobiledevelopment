package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void addTest() {
        int result = App.add(4, 5);
        assertEquals(9, result);
    }

    @Test
    public void evenTest() {
        boolean result = App.even(3);
        assertNotEquals(true, result);
        assertNull(null); 
    }
}
