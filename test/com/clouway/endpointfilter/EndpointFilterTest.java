package com.clouway.endpointfilter;

/**
 * @author Aleksandar Hristov <alexanderhristov93@gmail.com>
 */

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EndpointFilterTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private Endpoint endpoint = context.mock(Endpoint.class);
    private EndpointFilter endpointFilter = new EndpointFilter(endpoint);

    @Test
    public void happyPath() {
        context.checking(new Expectations() {{
            oneOf(endpoint).matches(with(any(String.class)));
            will(returnValue(true));
        }});
        boolean result = endpointFilter.shouldFilter("test");
        assertTrue(result);
    }

    @Test
    public void endPointFilterNotMatches() {
        context.checking(new Expectations() {{
            oneOf(endpoint).matches(with(any(String.class)));
            will(returnValue(false));
        }});
        boolean result = endpointFilter.shouldFilter("test");
        assertFalse(result);
    }

    @Test
    public void multipleFitrations() {
        Endpoint endpoint1 = context.mock(Endpoint.class, "endPoint1");
        Endpoint endpoint2 = context.mock(Endpoint.class, "endPoint2");
        EndpointFilter endpointFilter = new EndpointFilter(endpoint, endpoint1, endpoint2);
        context.checking(new Expectations() {{
            oneOf(endpoint).matches(with(any(String.class)));
            will(returnValue(false));
            oneOf(endpoint1).matches(with(any(String.class)));
            will(returnValue(false));
            oneOf(endpoint2).matches(with(any(String.class)));
            will(returnValue(true));
        }});

        endpointFilter.shouldFilter("Url");
    }
}
