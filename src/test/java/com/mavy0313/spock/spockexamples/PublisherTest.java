package com.mavy0313.spock.spockexamples;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PublisherTest {

  private Publisher publisher = new Publisher();

  @Mock  private Subscriber subscriber;
  @Mock  private Subscriber subscriber2;

  @Before
  public void setUp() {
    publisher.subscribers.add(subscriber);
    publisher.subscribers.add(subscriber2);
  }

  @Test
  public void shouldSendMessagesToAllSubscribers() {
    // When
    publisher.send("hello");

    // Then
    verify(subscriber, times(1)).receive("hello");
    verify(subscriber2, times(1)).receive("hello");
  }

  @Test
  public void shouldSendMessagesToAllSubscribers2() {
    // Given
    when(subscriber.receive(any())).thenReturn("ok");

    // When
    publisher.send("hello");

    // Then
    verify(subscriber, times(1)).receive("hello");
    verify(subscriber2, times(1)).receive("hello");
  }
}