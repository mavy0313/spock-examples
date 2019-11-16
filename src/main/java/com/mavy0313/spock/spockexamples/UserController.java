package com.mavy0313.spock.spockexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/user/{id}")
  public String getUserById(@PathVariable("id") Long id) {
    User user = userRepository.findById(id).get();
    return user.getName();
  }
}
