package com.mavy0313.spock.spockexamples;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//  @ParameterizedTest(name = "{index} => first={0}, second={1}, expectedSum={2}")

public class Junit5CalculatorTest {

  @ParameterizedTest
  @CsvSource({
      "0, 0, 0",
      "1, 1, 2"
  })
  @DisplayName("Should return correct sum " +
               "very very long multiline test name " +
               "and one more line")
  public void shouldReturnCorrectSum(
      int first, int second, int expectedSum) {
    // given
    Calculator calculator = new Calculator();

    // when
    int actualSum = calculator.sum(first, second);

    // then
    assertEquals(expectedSum, actualSum);
  }
}