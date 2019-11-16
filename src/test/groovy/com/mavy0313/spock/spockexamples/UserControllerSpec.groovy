package com.mavy0313.spock.spockexamples

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [UserController])
class UserControllerSpec extends Specification {

  @Autowired
  private MockMvc mvc

  @SpringBean
  UserRepository userRepository = Mock()

  def "when get is performed then the response has status 200 and content is 'Spock'"() {
    given:
    userRepository.findById(1) >> Optional.of(new User("Spock"))

    when: "Status is 200 and the response is 'Spock'"
    def result = mvc.perform(get("/user/1"))

    then:
    result
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString() == "Spock"
  }
}
