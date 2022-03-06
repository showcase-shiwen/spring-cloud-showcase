package org.showcase.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"org.showcase.api.user"})
public class    Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
