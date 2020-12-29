package com.aaron.gyz.score.controller;

import com.aaron.gyz.userclient.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date: 2020/12/9 10:21
 * @Author: Aaron
 * @Description:
 */
@RestController
public class ScoreController {

    @Resource
    private UserClient userClient;

    @GetMapping("/score")
    public Object users() {
        String users = userClient.users();
        return String.format("%s,score-%s", users, 100);
    }

}
