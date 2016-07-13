package com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class UserRepository {
    private final Validator validator;
    private final UserDB userDB;


    public UserRepository(Validator validator, UserDB userDB) {
        this.userDB = userDB;
        this.validator = validator;
    }

    public void registerUser(User user) {
        if (validator.isValid(user)) {
            userDB.registerUser(user);
            }
        }


    public boolean isAdult(User user) {
        if(validator.isAdult(user) == true);
        return true;
        }
    }

