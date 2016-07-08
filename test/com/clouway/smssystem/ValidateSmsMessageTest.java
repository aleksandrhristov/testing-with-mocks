package com.clouway.smssystem;

import com.clouway.smssystem.RealSmsValidator;
import com.clouway.smssystem.SMS;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by clouway on 07.07.16.
 */
public class ValidateSmsMessageTest {
    private RealSmsValidator smsValidator = new RealSmsValidator();

    @Test
    public void happyPath() throws Exception {
        assertThat(smsValidator.isValid(new SMS("Hello", "+359899000001", "::message body::")), is(equalTo(true)));
    }

    @Test
    public void missingTitle() throws Exception {
        assertThat(smsValidator.isValid(new SMS("", "+359899000002", "::message body::")), is(equalTo(false)));
    }

    @Test
    public void numberIsMissing() throws Exception {
        assertThat(smsValidator.isValid(new SMS("Hello", "::title which is not mobile number::", "::message body::")), is(equalTo(false)));
    }

    @Test
    public void bodyIsMissing() throws Exception {
        assertThat(smsValidator.isValid(new SMS("Hello", "+359899000003", "")), is(equalTo(false)));
    }

    @Test
    public void longBody() throws Exception {
        assertThat(smsValidator.isValid(new SMS("Hello", "+359899000003", generateString(101))), is(equalTo(false)));
    }


    private String generateString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length;i++) {
            builder.append("a");
        }
        return builder.toString();
    }
}
