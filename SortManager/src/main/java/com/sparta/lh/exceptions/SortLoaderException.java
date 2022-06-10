package com.sparta.lh.exceptions;

public class SortLoaderException extends Throwable {
    private final String message;
    public SortLoaderException(String message) { this.message = message;}

    @Override
    public String getMessage() {
        return message;
    }
}
