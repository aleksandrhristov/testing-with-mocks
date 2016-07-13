package com.clouway.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class ValidateUserData {
    private RealUserValidator realUserValidator = new RealUserValidator();

    @Test
    public void happypath() {         //happypath all the data is valid and user is registered to DB
        assertThat(realUserValidator.isValid(new User("Aleksndar", "Hristov", "20")), is(equalTo(true)));
    }

    @Test
    public void missingFirstName() throws Exception {
        assertThat(realUserValidator.isValid(new User("", "Hristov", "20")), is(equalTo(false)));
    }

    @Test
    public void isAdult() throws Exception {
        assertThat(realUserValidator.isAdult(new User("Aleksandar","Hristov","22")),is(equalTo(true)));

    }
    @Test
    public void isMature() throws Exception {
        assertThat(realUserValidator.isAdult(new User("Aleksandar","Hristov","1")),is(equalTo(false)));

    }
}
