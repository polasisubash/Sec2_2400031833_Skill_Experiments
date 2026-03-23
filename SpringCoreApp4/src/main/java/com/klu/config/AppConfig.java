
package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.beans.Address;
import com.klu.beans.Student;

@Configuration
public class AppConfig {
  @Bean
  public Student getStudent() {
    //create Student object
    Student s = new Student();
    //assign primitive values into student object by calling setters
    s.setSid(1001);
    s.setSname("Subash");
    s.setEmail("Subashpolasi55@gmail.com");
    
    //return student object along with values
    // (internally @Autowired automatically injects Address object using setter)
    return s;
  }
  @Bean
  public Address getAddress() {
    //create Address object
    Address addr = new Address();
    //assign primitive values into Address object by calling setters
    addr.setStreet("Rmalayam street");
    addr.setCity("Mangalagiri");
    addr.setState("Andhra Pradesh");
    
    //return Address object along with values
    return addr;
  }
}