package org.mstudio.mstarter.config;

import lombok.extern.slf4j.Slf4j;
import org.mstudio.mstarter.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Macrow
 * @date 2020/2/27
 */
@Slf4j
@RestController
public class BasicErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(ERROR_PATH)
    public Result handleError(HttpServletRequest request, HttpServletResponse response) {
        switch (response.getStatus()) {
            case 401:
                log.error("401错误:" + getErrorAttributes(request));
                return Result.noAuth();
            case 403:
                log.error("403错误:" + getErrorAttributes(request));
                return Result.forbidden();
            case 404:
                log.error("404错误:" + getErrorAttributes(request));
                return Result.noFound();
            case 500:
                log.error("500错误:" + getErrorAttributes(request));
                return Result.error();
            default:
                log.error(response.getStatus() + "错误:" + getErrorAttributes(request));
                return Result.error();
        }
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(servletWebRequest, true);
    }
}