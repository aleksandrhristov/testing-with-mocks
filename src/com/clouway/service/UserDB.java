package com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public interface UserDB {
    boolean registerUser(User user);
    boolean isAdult(User user);
}
