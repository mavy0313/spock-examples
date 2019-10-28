package com.mavy0313.spock.spockexamples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ExceptionsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = ArithmeticException.class)
    public void ArithmeticExceptionIsThrown() {
        //when
        int result = 5 / 0;

        //then
        //exception is thrown
    }

    @Test
    public void ArithmeticExceptionIsThrownWithRule() {
        //given
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("/ by zero");

        //when
        int result = 5 / 0;

        //then
        //exception is thrown
    }

    @Test
    public void ArithmeticExceptionIsThrownWithAssertJ() {
        //when
        Throwable thrown = catchThrowable(() ->  { int result = 5 / 0; });

        //then
        assertThat(thrown).isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageContaining("zero");
    }
}
