package com.mavy0313.spock.spockexamples;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit4Tests {

//  @BeforeClass
//  @AfterClass
  @Before
//  @After
  public void setUp() throws Exception {

  }

  @Test
  public void shouldBeAbleToRemoveFromList() {
    // given
    List<Integer> list = new ArrayList<>(asList(1, 2, 3));

    // when
    list.remove(0);

    // then
    assertFalse(list.isEmpty());
    assertEquals(asList(1, 2, 3), list);
  }
}
