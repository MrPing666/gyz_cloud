package com.aaron.gyz.score;

import com.aaron.gyz.common.constant.Constant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients(basePackages = Constant.USER_CLIENT_PACKAGE)
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = Constant.BASE_PACKAGE)
public class ScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreApplication.class, args);
    }

}
