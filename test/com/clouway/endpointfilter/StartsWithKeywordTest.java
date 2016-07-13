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
    public void endPointIsMatching() {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("Start");
        assertTrue(startsWithKeyword.matches("Start with"));
    }

    @Test
    public void endPointNotMatch() {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("StartKeyWord");
        assertFalse(startsWithKeyword.matches("SomeUrl"));
    }
}
