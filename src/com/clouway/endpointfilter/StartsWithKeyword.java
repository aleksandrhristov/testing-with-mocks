package com.clouway.endpointfilter;

/**
 * @author Aleksandar Hristov <alexanderhristov93@gmail.com>
 */
class StartsWithKeyword implements Endpoint {
    private final String keyWord;

    public StartsWithKeyword(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public boolean matches(String url) {
        if (url.isEmpty()) {
            return false;
        }
        if (keyWord.isEmpty()) {
            return false;
        }
        if (url.startsWith(keyWord)) {
            return true;
        }
        return false;
    }
}
