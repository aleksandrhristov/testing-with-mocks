package com.clouway.endpointfilter; /**
 * @author Aleksandar Hristov <Email:alexanderhristov93@gmail.com>
 */



import com.clouway.endpointfilter.Endpoint;
import com.clouway.endpointfilter.EndpointFilter;

import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by clouway on 07.07.16.
 */
public class EndpointFilterTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private Endpoint endpoint = context.mock(Endpoint.class);
    private EndpointFilter endpointFilter = new EndpointFilter(endpoint);

    @Test
    public void endPointIsMatching() throws MissingURLException, MissingKeywordException {
        context.checking(new Expectations() {{
            oneOf(endpoint).matches(with(any(String.class)));
            will(returnValue(true));
        }});
        boolean result = endpointFilter.shouldFilter("test");
        assertTrue(result);
    }

    @Test
    public void endPointIsNotMatching() throws MissingURLException, MissingKeywordException {
        context.checking(new Expectations() {{
            oneOf(endpoint).matches("ThisUrlDoesNotMatch");
            will(returnValue(false));
        }});
        EndpointFilter endpointFilter = new EndpointFilter(endpoint);
        assertFalse(endpointFilter.shouldFilter("ThisUrlDoesNotMatch"));
    }

    @Test
    public void endPointMany() throws MissingKeywordException, MissingURLException {
        final Sequence matchEndpoints = context.sequence("MatchEndpoints");
        Endpoint endpoint1 = context.mock(Endpoint.class, "endPoint1");
        Endpoint endpoint2 = context.mock(Endpoint.class, "endPoint2");
        EndpointFilter endpointFilter = new EndpointFilter(endpoint, endpoint1, endpoint2);

        context.checking(new Expectations() {{
            oneOf(endpoint).matches("Url");
            inSequence(matchEndpoints);
            will(returnValue(false));
            oneOf(endpoint1).matches("Url");
            inSequence(matchEndpoints);
            will(returnValue(false));
            oneOf(endpoint2).matches("Url");
            inSequence(matchEndpoints);
            will(returnValue(true));
        }});
        endpointFilter.shouldFilter("Url");
    }
}

