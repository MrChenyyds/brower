package org.demo.brower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"org.demo.*"})
public class BrowerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrowerApplication.class, args);
    }
}
