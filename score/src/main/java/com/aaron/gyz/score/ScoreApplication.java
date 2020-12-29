package com.aaron.gyz.score;

import com.aaron.gyz.common.constant.Constant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = Constant.BASE_PACKAGE)
@EnableEurekaClient
@SpringBootApplication
public class ScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreApplication.class, args);
    }

}
