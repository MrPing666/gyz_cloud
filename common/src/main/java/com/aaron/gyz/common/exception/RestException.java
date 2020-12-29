package com.aaron.gyz.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Date: 2020/12/17 15:19
 * @Author: Aaron
 * @Description:
 */
@Getter
@AllArgsConstructor
public class RestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;
}
