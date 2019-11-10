package com.mavy0313.spock.spockexamples

import org.testcontainers.containers.GenericContainer
import spock.lang.Specification

class RedisIntSpec extends Specification {

  RedisBackedCache underTest
  GenericContainer redis = new GenericContainer<>("redis:5.0.3-alpine")
      .withExposedPorts(6379)

  void setup() {
    String address = redis.containerIpAddress
    Integer port = redis.firstMappedPort

    underTest = new RedisBackedCache(address, port)
  }

  def "Test simple put and get"() {
    setup:
    underTest.put("test", "example")

    when:
    String retrieved = underTest.get("test")

    then:
    retrieved == "example"
  }
}

