package com.clouway.smssystem;

/**
 * Created by clouway on 07.07.16.
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
