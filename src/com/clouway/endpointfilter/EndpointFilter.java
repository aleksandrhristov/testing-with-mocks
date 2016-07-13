package com.clouway.endpointfilter;

/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
public class EndpointFilter {
    private final Endpoint[] endpoints; // array of endpoints
    // constructor of the EndpointFilter
    public EndpointFilter(Endpoint... endpoints) {
        this.endpoints = endpoints;
    }
    //checking for every endpoint if url matches returns true else false
//checking for every endpoint if url matches returns true else false
    public boolean shouldFilter(String url) {
        for (Endpoint each : endpoints) {
            if (each.matches(url)) {
                return true;
            }
        }
        return false;
    }
}
