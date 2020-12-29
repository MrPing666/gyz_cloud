package com.aaron.gyz.common.config;

import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2020/12/17 15:19
 * @Author: Aaron
 * @Description:
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class FeignConfig {

//    private final ObjectMapper objectMapper;
    private final ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    @Bean
    public Decoder springDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
    }

    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }

//    @Bean
//    public ErrorDecoder apiErrorResponseDecoder() {
//        return (methodKey, response) -> {
//            try {
//                ApiErrorResponse errorResponse = objectMapper.readValue(Util.toString(
//                        response.body().asReader(StandardCharsets.UTF_8)), ApiErrorResponse.class);
//                log.error("feign exception, status: {}, body: {}", response.status(), errorResponse.getMessage());
//                throw new RestException(errorResponse.getMessage(), HttpStatus.valueOf(response.status()));
//            } catch (Exception e) {
//                log.error("decoding feign response exception: ", e);
//                throw new RestException("System service abnormal, please try again later!", HttpStatus.SERVICE_UNAVAILABLE);
//            }
//        };
//    }
}
