package org.mstudio.mstarter.config;

import lombok.extern.slf4j.Slf4j;
import org.mstudio.mstarter.base.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Macrow
 * @date 2020/2/27
 */
@Slf4j
@RestController
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.warn(e.getLocalizedMessage(), e);
        return Result.failed(e.getLocalizedMessage());
    }
}
