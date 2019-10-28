package com.mavy0313.spock.spockexamples;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Junit4CalculatorTest {

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { 0, 0, 0 }, { 1, 1, 2 }
    });
  }

  private final int first;
  private final int second;
  private final int expectedSum;

  public Junit4CalculatorTest(int first, int second, int expectedSum) {
    this.first = first;
    this.second = second;
    this.expectedSum = expectedSum;
  }

  @Test
  public void shouldReturnCorrectSum() {
    // given
    Calculator calculator = new Calculator();

    // when
    int actualSum = calculator.sum(first, second);

    // then
    assertEquals(expectedSum, actualSum);
  }
}