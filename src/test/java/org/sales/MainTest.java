package org.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testIsInteger_ValidInteger_ReturnsInteger() {
        int result = Main.isInteger("123");
        assertEquals(123, result);
    }

}