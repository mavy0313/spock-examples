package com.mavy0313.spock.spockexamples

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITSpec extends Specification {

  @Autowired
  TestRestTemplate restTemplate

  @Autowired
  UserRepository userRepository

  def "Insert a User Entity and retrieve user name via GET /user/1"() {
    given: "A User Entity"
    userRepository.save(new User("Spock"))

    when: "GET /user/1"
    def result = restTemplate.getForObject("/user/1", String.class)

    then: "The result is 'Spock'"
    result == "Spock"

    cleanup:
    userRepository.deleteAll()
  }
}
