package com.clouway.endpointfilter;

/**
 * @author Aleksandar Hristov <alexanderhristov93@gmail.com>
 */

/**
 * Comparison the url.
 *@param url the first number to sum
 *@return url is matches or not matches (true or false)(boolean)
 */

public interface Endpoint {
    boolean matches(String url);
}
