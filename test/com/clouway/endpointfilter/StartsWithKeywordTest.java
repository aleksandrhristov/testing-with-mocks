package com.clouway.endpointfilter;
/**
 * @author Aleksandar Hristov <alexanderhristov93@gmail.com>
 */
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by clouway on 07.07.16.
 */
public class StartsWithKeywordTest {
    @Test
    public void endPointIsMatches() {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("Start");
        assertTrue(startsWithKeyword.matches("Start with"));
    }

    @Test
    public void endPointNotMatches() {
        StartsWithKeyword startsWithKeyword = new StartsWithKeyword("StartKeyWord");
        assertFalse(startsWithKeyword.matches("SomeUrl"));
    }
}
