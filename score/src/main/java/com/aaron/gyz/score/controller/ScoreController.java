package com.aaron.gyz.score.controller;

import com.aaron.gyz.common.exception.CloudException;
import com.aaron.gyz.userclient.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date: 2020/12/9 10:21
 * @Author: Aaron
 * @Description:
 */
@Slf4j
@RestController
public class ScoreController {

    @Resource
    private UserClient userClient;

    @GetMapping("/score/{id}")
    @HystrixCommand(fallbackMethod = "userScoreFail")
    public Object userScore(@PathVariable long id) {
        if(id > 100) {
            throw new CloudException("not exist!");
        }
        String userInfo = userClient.getById(id);
        return String.format("%s, score-%s", userInfo, 100);
    }

    public Object userScoreFail(long id) {
        return String.format("user [%s] not exist!", id);
    }

}
