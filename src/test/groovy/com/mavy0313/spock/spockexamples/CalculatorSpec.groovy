package com.mavy0313.spock.spockexamples

import spock.lang.Specification

class CalculatorSpec extends Specification {

  def "Should return correct sum"() {
    given:
    def calculator = new Calculator()

    when:
    def actualSum = calculator.sum(first, second)

    then:
    actualSum == expectedSum

    where:
    first | second || expectedSum
    0     | 0      || 0
    1     | 1      || 2
  }
}
