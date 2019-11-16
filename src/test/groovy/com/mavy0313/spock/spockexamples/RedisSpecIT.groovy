package com.mavy0313.spock.spockexamples

import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

@Testcontainers
class RedisSpecIT extends Specification {

  RedisCache redisCache

  GenericContainer redis = new GenericContainer<>(
      "redis:5.0.3-alpine")
      .withExposedPorts(6379)

  void setup() {
    String address = redis.containerIpAddress
    Integer port = redis.firstMappedPort
    redisCache = new RedisCache(address, port)
  }

  def "Test simple put and get"() {
    setup:
    redisCache.put("test", "example")

    when:
    String result = redisCache.get("test")

    then:
    result == "example"
  }
}

