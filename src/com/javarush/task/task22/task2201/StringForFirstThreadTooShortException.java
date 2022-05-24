package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {

    public StringForFirstThreadTooShortException(String name, Throwable cause){
        super(name);
        super.initCause(cause);
    }

}


























