package com.mavy0313.spock.spockexamples;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpockExamplesApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void givenTwoAndTwo_whenAdding_thenResultIsFour() {
		// Given
		int first = 2;
		int second = 4;

		// When
		int result = 2 + 2;

		// Then
		assertTrue(result == 4);
	}

}
