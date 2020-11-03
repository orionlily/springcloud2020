package com.orion.alibaba.seata.config;

import com.orion.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author li.lc
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public CommonResult actionExceptionHandle(Exception e, HttpServletRequest request) {
        log.warn("发生Exception异常（{}） :", request.getRequestURI(), e);
        return new CommonResult(500,"异常了");
    }
}
