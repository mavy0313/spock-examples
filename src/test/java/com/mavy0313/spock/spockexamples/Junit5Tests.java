package com.mavy0313.spock.spockexamples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Junit5Tests {

  @Test
  @DisplayName("Smoke test")
  void name() {
    assertTrue(true);
  }
}
