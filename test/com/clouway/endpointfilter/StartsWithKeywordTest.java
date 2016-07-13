/**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */
package com.clouway.endpointfilter;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by clouway on 07.07.16.
 */
public class StartsWithKeywordTest {
    @Test
    public void endPointIsMatching() throws MissingURLException, MissingKeywordException {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("Start");
        assertTrue(startsWithKeyword.matches("Start with"));
    }

    @Test(expected = MissingURLException.class)
    public void emptyUrl() throws MissingURLException, MissingKeywordException {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("Start");
        startsWithKeyword.matches("");
    }

    @Test
    public void endPointDoesNotMatch() throws MissingURLException, MissingKeywordException {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("StartKeyWord");

        assertFalse(startsWithKeyword.matches("SomeUrl"));
    }

    @Test(expected = MissingKeywordException.class)
    public void emptyEndPoint() throws MissingURLException, MissingKeywordException {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("");

        startsWithKeyword.matches("SomeUrl");
    }
}
