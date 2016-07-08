package com.clouway.com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class RealUserValidator implements Validator {
    public boolean isValid(User user) {
        if (user.isWithEmptyFirstName()) {
            return false;
        }
        if (user.isWithEmptyLastName()) {
            return false;
        }

        if (!user.ValidateUserAge(10, 100)) {
            return false;
        }
        return true;
    }
}
