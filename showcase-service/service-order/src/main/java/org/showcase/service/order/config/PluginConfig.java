package org.showcase.service.order.config;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {
        "org.showcase.common.config.feign",
        "org.showcase.common.config.logconfig",
        "org.showcase.api",
})
//自身  启用服务发现
@EnableDiscoveryClient
//扫描调用client
@EnableFeignClients("org.showcase.api")
@EnableHystrix
public class PluginConfig {


}
