package ccc.springboot.coconut.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

// this is for dequeue message
@RestController
public class CustomerController {

  @JmsListener(destination = "active.queue")
  public void readActiveQueue(String message) {
    System.out.println("Received message: " + message);
  }
}
