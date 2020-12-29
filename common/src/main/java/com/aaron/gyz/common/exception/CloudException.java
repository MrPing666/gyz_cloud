package com.aaron.gyz.common.exception;

public class CloudException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final String message;

    public CloudException(Exception e) {
        super(e);
        this.message = e.getMessage();
    }

    public CloudException(String message) {
        super(message);
        this.message = message;
    }

    public CloudException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }
}
