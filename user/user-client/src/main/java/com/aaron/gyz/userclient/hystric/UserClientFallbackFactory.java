package com.aaron.gyz.userclient.hystric;

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
            public String getById(long id) {
                log.error("feign [getById] Exception:", throwable.getMessage());
                return String.format("user [%s] not exist!", id);
            }
        };
    }
}
