package com.mavy0313.spock.spockexamples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_id_seq")
  @SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  public User(String name) {
    this.name = name;
  }

  public User() {
    // Default constructor needed by JPA
  }

  public String getName() {
    return name;
  }
}
