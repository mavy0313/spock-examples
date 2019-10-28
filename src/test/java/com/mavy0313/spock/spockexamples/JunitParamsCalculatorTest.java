package com.mavy0313.spock.spockexamples;

import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class JunitParamsCalculatorTest {

  @Test
  @Parameters({
      "0, 0, 0",
      "1, 1, 2"
  })
  public void shouldReturnCorrectSum(int first, int second, int expectedSum) {
    // given
    Calculator calculator = new Calculator();

    // when
    int actualSum = calculator.sum(first, second);

    // then
    assertEquals(expectedSum, actualSum);
  }
}