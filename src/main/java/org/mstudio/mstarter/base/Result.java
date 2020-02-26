package org.mstudio.mstarter.base;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @author Macrow
 * @date 2020/2/26
 */
public class Result extends ResponseEntity<Object> {
    private static final String MESSAGE_SUCCESS = "操作成功";
    private static final String MESSAGE_FAILED = "操作失败";

    private Result(Object body, HttpStatus status) {
        super(body, status);
    }

    public static Result success() {
        return new Result(RawResult.build(HttpStatus.OK, true, MESSAGE_SUCCESS, null), HttpStatus.OK);
    }

    public static Result success(String message) {
        return new Result(RawResult.build(HttpStatus.OK, true, message, null), HttpStatus.OK);
    }

    public static Result success(Object result) {
        return new Result(RawResult.build(HttpStatus.OK, true, MESSAGE_SUCCESS, result), HttpStatus.OK);
    }

    public static Result success(String message, Object result) {
        return new Result(RawResult.build(HttpStatus.OK, true, message, result), HttpStatus.OK);
    }

    public static Result created(Object result) {
        return new Result(RawResult.build(HttpStatus.CREATED, true, MESSAGE_SUCCESS, result), HttpStatus.CREATED);
    }

    public static Result deleted() {
        return new Result(RawResult.build(HttpStatus.NO_CONTENT, true, MESSAGE_SUCCESS, null), HttpStatus.NO_CONTENT);
    }

    public static Result failed() {
        return new Result(RawResult.build(HttpStatus.BAD_REQUEST, false, MESSAGE_FAILED, null), HttpStatus.BAD_REQUEST);
    }

    public static Result failed(String message) {
        return new Result(RawResult.build(HttpStatus.BAD_REQUEST, false, message, null), HttpStatus.BAD_REQUEST);
    }

    public static Result error() {
        return new Result(RawResult.build(HttpStatus.INTERNAL_SERVER_ERROR, false, MESSAGE_FAILED, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static Result error(String message) {
        return new Result(RawResult.build(HttpStatus.INTERNAL_SERVER_ERROR, false, message, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    private static class RawResult implements Serializable {
        private Integer code;
        private Boolean success;
        private String message;
        private Object result;

        public RawResult(HttpStatus code, Boolean success, String message, Object result) {
            this.code = code.value();
            this.success = success;
            this.message = message;
            this.result = result;
        }

        public static RawResult build(HttpStatus status, Boolean success, String message, Object result) {
            return new RawResult(status, success, message, result);
        }
    }
}
