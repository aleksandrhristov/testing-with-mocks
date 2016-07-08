package com.clouway.service;

import com.clouway.com.clouway.service.RealUserValidator;
import com.clouway.com.clouway.service.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class ValidateUserDataTest {
    private RealUserValidator realUserValidator = new RealUserValidator();
    @Test
    public  void happypath(){         //happypath all the data is valid and user is registered to DB
        assertThat(realUserValidator.isValid( new User("Aleksndar","Hristov" , "20")),is(equalTo(true)));
    }

    @Test
    public void missingFirstName() throws Exception {
        assertThat(realUserValidator.isValid( new User("","Hristov","20")),is(equalTo(false)));

    }
    @Test
    public void missingLastName() throws Exception {
        assertThat(realUserValidator.isValid( new User("Aleksandar","","20")),is(equalTo(false)));

    }
    @Test(expected = NumberFormatException.class)
    public void missingAge() throws Exception {
        assertThat(realUserValidator.isValid( new User("Aleksandar","Hristov","")),is(equalTo(false)));

    }

    @Test(expected = NumberFormatException.class)
    public void longAge() throws NumberFormatException {
        assertThat(realUserValidator.isValid(new User("Aleksandar", "Hristov", generateString(101))), is(equalTo(false)));
    }
    @Test
    public void lessAge() throws Exception {
        assertThat(realUserValidator.isValid( new User("Aleksandar","Hristov","2")),is(equalTo(false)));

    }

    private String generateString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length;i++) {
            builder.append("a");
        }
        return builder.toString();
    }
}



