package com.dchristofolli.exception;

import java.io.Serializable;

public class ApiException extends Throwable implements Serializable {
    private static final long serialVersionUID = 1L;

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, java.lang.Exception e) {
        super(message, e);
    }
}
