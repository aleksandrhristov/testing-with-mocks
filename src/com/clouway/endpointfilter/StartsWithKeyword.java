package com.clouway.endpointfilter;

/**
 * Created by clouway on 07.07.16.
 */

class StartsWithKeyword implements Endpoint {   // implements the interface Endpoint
    private final String keyWord; //field for keyword
    //adding to the constructor Keyworrd
    public StartsWithKeyword(String keyWord) {
        this.keyWord = keyWord;
    }
//overriding matches      if url is empty throw exec if keyword is empty throw exec if url stars with keyword return true else false ;
    @Override
    public boolean matches(String url) {

        if (url.isEmpty()) {
            throw new MissingURLException();
        }

        if (keyWord.isEmpty()) {
            throw new MissingKeywordException();
        }

        if (url.startsWith(keyWord)) {
            return true;
        }
        return false;
    }


}
