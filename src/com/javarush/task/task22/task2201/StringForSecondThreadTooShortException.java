package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {

    public StringForSecondThreadTooShortException(String message, Throwable cause){
        super(message);
        super.initCause(cause);
    }

}






























