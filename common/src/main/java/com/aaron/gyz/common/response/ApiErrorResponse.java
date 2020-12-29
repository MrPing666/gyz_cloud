package com.aaron.gyz.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Date: 2020/12/17 15:19
 * @Author: Aaron
 * @Description:
 */
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    private String message;

    private ApiErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ApiErrorResponse createByMessage(String message) {
        return new ApiErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), message);
    }
}
