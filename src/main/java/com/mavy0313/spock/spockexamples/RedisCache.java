package com.mavy0313.spock.spockexamples;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class RedisCache {

  private final StatefulRedisConnection<String, String> connection;

  public RedisCache(String hostname, Integer port) {
    RedisClient client = RedisClient.create(
        String.format("redis://%s:%d/0", hostname, port));
    connection = client.connect();
  }

  public String get(String key) {
    return connection.sync().get(key);
  }

  public void put(String key, String value) {
    connection.sync().set(key, value);
  }
}
