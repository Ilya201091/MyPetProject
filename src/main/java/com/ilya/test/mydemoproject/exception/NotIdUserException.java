package com.ilya.test.mydemoproject.exception;

/**
 * @author Shaporto Ilya
 * @date 19.12.2021
 */
public class NotIdUserException extends Exception{
    public NotIdUserException(String message, Long id) {
        super(message);
    }
}
