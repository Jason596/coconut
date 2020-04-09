package ccc.springboot.coconut;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CoconutApplication {

  @Bean
  public Queue queue() {
    return new ActiveMQQueue(
        "active.queue"); // this line of code created an internal activemq. but you could also
  }                               // use an external activemq with specify details in application.yaml.

  public static void main(String[] args) {
    SpringApplication.run(CoconutApplication.class, args);
  }
}
