package com.aaron.gyz.userclient.hystric;

import com.aaron.gyz.common.exception.CloudException;
import com.aaron.gyz.userclient.UserClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020/12/17 15:19
 * @Author: Aaron
 * @Description:
 */
@Slf4j
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {

        return new UserClient() {
            @Override
            public String users() {
                log.error("feign [users] Exception: ", throwable);
                throw new CloudException("feign [users] Exception: ", throwable);
            }
        };
    }
}
