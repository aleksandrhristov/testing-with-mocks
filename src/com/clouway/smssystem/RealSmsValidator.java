package com.clouway.smssystem;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class RealSmsValidator implements Validator{
    public boolean isValid(SMS sms) {

        if (sms.isWithEmptyTitle()) {
            return false;
        }

        if (sms.isWithWrongMobileNumber()) {
            return false;
        }

        if (!sms.bodySizeIsInRange(10, 100)) {
            return false;
        }

        return true;
    }
}
