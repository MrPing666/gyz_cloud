package com.aaron.gyz.userserver.controller;

import com.aaron.gyz.common.exception.CloudException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/user/{id}")
    public String getById(@PathVariable long id) {
        if(id > 10) {
            throw new CloudException("user not exist!");
        }
        return String.format("port-%s, user-%s, id-%s", port, user, id);
    }
}
