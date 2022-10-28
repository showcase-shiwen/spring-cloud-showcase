package org.showcase.system.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigRest {
    private String name;
    @GetMapping("name")
    public String getName(){
        return name;
    }
}
