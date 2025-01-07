package com.xxx.springboot01.exception;

public class BookIdMismatchException extends RuntimeException{
    public BookIdMismatchException(String message, Throwable cause){
        super(message, cause);
    }
}
