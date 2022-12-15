package com.adrainty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.adrainty"})
public class AdraintyBlogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdraintyBlogBackendApplication.class, args);
    }

}
