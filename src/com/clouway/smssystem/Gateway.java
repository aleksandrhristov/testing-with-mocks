package com.clouway.smssystem;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */


public class Gateway {
    private final Validator validator;
    private final Sender sender;

    public Gateway(Validator validator, Sender sender) {
        this.validator = validator;
        this.sender = sender;
    }

    public void send(SMS sms) {
        if (validator.isValid(sms)) {
            if (!sender.send(sms)) {
                throw new MessageNotDeliveredException();
            }
        }

    }
}
