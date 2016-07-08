package com.clouway.smssystem;

/**
 * Created by clouway on 07.07.16.
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
