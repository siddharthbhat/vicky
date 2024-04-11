package com.ee417.website.group.util;

import org.springframework.http.HttpStatus;

/*
 * @created 09/03/2023
 * @project lecture-demo
 * @author Katarzyna Fidos
 */
public enum ErrorCode {

    DUPLICATE_RECORDING(HttpStatus.BAD_REQUEST),
    INVALID_USER_REQUEST(HttpStatus.BAD_REQUEST),
    UNEXPECTED_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST),
    ROOM_NOT_FOUND(HttpStatus.BAD_REQUEST);
    private final HttpStatus status;
    ErrorCode(HttpStatus status) {
        this.status = status;
    }


    public HttpStatus getHttpStatus() {
        return this.status;
    }

    public String getCodeName() {
        return name();
    }
}