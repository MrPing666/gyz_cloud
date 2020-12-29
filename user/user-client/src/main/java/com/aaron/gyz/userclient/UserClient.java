package com.aaron.gyz.userclient;

import com.aaron.gyz.common.config.FeignConfig;
import com.aaron.gyz.userclient.hystric.UserClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date: 2020/12/16 15:56
 * @Author: Aaron
 * @Description:
 */
@FeignClient(name = "user-server", configuration = FeignConfig.class, fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    @GetMapping("/users")
    String users();

}
