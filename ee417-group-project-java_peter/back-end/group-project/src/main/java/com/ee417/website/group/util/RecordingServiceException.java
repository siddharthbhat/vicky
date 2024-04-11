package com.ee417.website.group.util;

public class RecordingServiceException extends RuntimeException {
	ErrorCode errorCode;
    public RecordingServiceException(String message, ErrorCode errorCode) {
        this(message, errorCode, null);
    }
    
    public RecordingServiceException(final String message, ErrorCode errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
