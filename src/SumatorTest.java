/**
 * Created by clouway on 22.06.16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumatorTest {

    @Test
    public void correctSymbolRecieve() {
        Sumator testone = new Sumator();
        String result = testone.sum("3", "5");
        assertEquals("8", result);
    }

    @Test
    public void corrrectSymbolRecieve() {
        Sumator testone = new Sumator();
        String result = testone.sum("22", "11");
        assertEquals("33", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothArgumentsAreNull() {
        Sumator sumator = new Sumator();
        sumator.sum(null, null);
    }

    @Test(expected = NumberFormatException.class)
    public void testNumberFormatException() {
        Sumator sumator = new Sumator();
        sumator.sum(":", "#");
    }
}
