package com.clouway.com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class User {
    private final String firstName;
    private final String lastName;
    private final String age;

    public User(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    //// TODO: 12.07.16  
    public boolean isWithEmptyFirstName() {
        return firstName.isEmpty();
    }
    public  boolean isWithEmptyLastName() {
        return  lastName.isEmpty();
    }
    public boolean ValidateUserAge(int low, int high) {
        int a = Integer.parseInt(age);
        return a > low && high >= a;
    }
}
