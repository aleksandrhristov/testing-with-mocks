package com.clouway.com.clouway.service;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class GatewayApp {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository(new RealUserValidator(), user -> {
            System.out.println("User Added to Database");
            return true;
        });
        userRepository.registerUser(new User("Aleksandar", "Hristov", "22"));
    }
}
