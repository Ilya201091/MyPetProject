package com.ilya.test.mydemoproject.exception;

/**
 * @author Shaporto Ilya
 * @date 18.12.2021
 */
public class LoginExistsException extends Exception {
    public LoginExistsException(String s, String message) {
        super(message);
    }
}
