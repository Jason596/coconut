package ccc.springboot.coconut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CoconutApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoconutApplication.class, args);
    }

}
