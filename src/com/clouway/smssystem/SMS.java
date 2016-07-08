package com.clouway.smssystem;

/**
 * Created by clouway on 07.07.16.
 */
public class SMS {
    private final String title;
    private final String number;
    private final String body;

    public SMS(String title, String number, String body) {

        this.title = title;
        this.number = number;
        this.body = body;
    }


    public boolean isWithEmptyTitle() {
        return title.isEmpty();
    }

    public boolean isWithWrongMobileNumber() {
        return !number.matches("\\+[0-9]{12}");
    }

    public boolean bodySizeIsInRange(int low, int high) {
        return body.length() > low && high >= body.length();
    }
}
