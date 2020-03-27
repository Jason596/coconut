package ccc.springboot.coconut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
public class QueueController {

  private JmsMessagingTemplate jmsMessagingTemplate;
  private Queue queue;

  @Autowired
  public QueueController(JmsMessagingTemplate jmsMessagingTemplate, Queue queue) {
    this.jmsMessagingTemplate = jmsMessagingTemplate;
    this.queue = queue;
  }

  @RequestMapping("/send")
  public void send() {
    // destination and information
    this.jmsMessagingTemplate.convertAndSend(this.queue, "new message !");
  }
}
