package org.showcase.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = {"index", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("user/info")
    public Object getUserinfo(Authentication authentication){
        return authentication.getPrincipal();
    }
}
