package com.mavy0313.spock.spockexamples;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

  List<Subscriber> subscribers = new ArrayList<>();
  private int messageCount = 0;

  public void send(String message){
    subscribers.forEach(s -> {
      s.receive(message);
      messageCount++;
    });
  }
}
