package com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public interface Validator {
    boolean isValid(User user);
    boolean isAdult(User user);
}
