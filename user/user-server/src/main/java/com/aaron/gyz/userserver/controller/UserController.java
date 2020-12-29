package com.aaron.gyz.userserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/12/8 16:15
 * @Author: Aaron
 * @Description:
 */
@Slf4j
@RestController
@RefreshScope
public class UserController {

    @Value("${server.port}")
    private String port;
    @Value("${user}")
    private String user;

    @GetMapping("/users")
    public String users() {
        return String.format("port-%s,user-%s", port, user);
    }
}
