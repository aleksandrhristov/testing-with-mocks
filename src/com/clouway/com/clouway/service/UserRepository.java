package com.clouway.com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class UserRepository {
    private final Validator validator;
    private final UserDB userDB;


    public UserRepository( Validator validator, UserDB userDB) {
        this.userDB = userDB;
        this.validator = validator;
    }

    public void registerUser(User user) {
        if (validator.isValid(user)) {
            if (!userDB.registerUser(user)) {
                throw new UserNotAddedToDBException();
            }
        }
    }

    public boolean isAdult(String name) {
        return false;
    }
}
