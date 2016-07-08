package com.clouway.endpointfilter;

/**
 * Created by clouway on 07.07.16.
 */
// Interface which will be mocked !
public interface Endpoint {

    //Matching Url in String Format
    boolean matches(String url);
}
