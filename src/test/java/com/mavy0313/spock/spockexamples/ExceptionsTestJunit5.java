package com.mavy0313.spock.spockexamples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionsTestJunit5 {

    @Test
    public void ArithmeticExceptionIsThrownWithJunit5() {
        //when
        Exception ex = assertThrows(ArithmeticException.class, () -> {
            int result = 5 / 0;
        });

        //then
        assertEquals("/ by zero", ex.getMessage());
        assertTrue(ex.getMessage().contains("zero"));
    }
}
