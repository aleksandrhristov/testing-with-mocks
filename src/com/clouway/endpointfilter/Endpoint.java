package com.clouway.endpointfilter;

/**
 * @author Aleksandar Hristov <alexanderhristov93@gmail.com>
 */

public interface Endpoint {
    boolean matches(String url);
}
