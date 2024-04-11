package com.ee417.website.group.util;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;



/*
 * @created 09/03/2023
 * @project lecture-demo
 * @author Katarzyna Fidos
 */
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {RecordingServiceException.class})
    public ResponseEntity handleNoteServiceException(RecordingServiceException ex) {
        return mapToError(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(e -> e.getField() + " "+ e.getDefaultMessage() ).collect(Collectors.toList());
        StringJoiner joiner = new StringJoiner(" \n ", "", "");
        errors.forEach(joiner::add);
        return mapToError(joiner.toString(), ErrorCode.INVALID_USER_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Error> handleNotificationServiceException(Exception ex) {
        return mapToError(ex.getMessage(), ErrorCode.UNEXPECTED_SERVER_ERROR);
    }

    public static ResponseEntity<Error> mapToError(String message, ErrorCode errorCode) {
        return new ResponseEntity<>(new Error()
                .code(errorCode.getCodeName())
                .message(message)
                .status(errorCode.getHttpStatus().value()),
                errorCode.getHttpStatus());
    }

    static class Error {
        public Error() {
        }

        public Error code(String code) {

            this.code = code;
            return this;
        }

        public Error message(String message) {
            this.message = message;
            return this;
        }

        public Error status(Integer status) {
            this.status = status;
            return this;
        }
        private String code;

        private String message;

        private Integer status;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

    }
}
