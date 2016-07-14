package com.clouway.endpointfilter;

/**
 * @author Aleksandar Hristov <alexanderhristov93@gmail.com>
 */
public class EndpointFilter {
    private final Endpoint[] endpoints;

    public EndpointFilter(Endpoint... endpoints) {
        this.endpoints = endpoints;
    }

    public boolean shouldFilter(String url) {
        for (Endpoint endpoint : endpoints) {
            if (endpoint.matches(url)) {
                return true;
            }
        }
        return false;
    }
}
