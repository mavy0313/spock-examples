package com.mavy0313.spock.spockexamples

import org.spockframework.spring.SpringBean
import org.spockframework.spring.SpringSpy
import org.spockframework.spring.StubBeans
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
//@WebMvcTest
//@DataJpaTest
class SpringBootSpec extends Specification {

//  @StubBeans
//  @SpringSpy
//  @SpringBean
  SystemUnderTest systemUnderTest
//  @Autowired
//  WebApplicationContext context

  def "Should start spring context"() {
    expect:
    true
  }
}
