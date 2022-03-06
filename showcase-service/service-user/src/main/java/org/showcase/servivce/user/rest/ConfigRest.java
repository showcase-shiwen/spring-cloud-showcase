package org.showcase.servivce.user.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
@Slf4j
@RefreshScope
public class ConfigRest {
    @GetMapping("get")
    public String get(@Value("${name:default}") String name){
        log.info("config get:{}",name);
        return name;
    }
}
