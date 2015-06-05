package exercise01;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Changes:
 * 
 * - added test to check if the actual table is modified after using match method
 * - added setUp method
 * 
 * @author kelu
 */
public class MatcherTest {
    
    Matcher matcher;
    int clipLimit;
    int delta;
    
    @Before
    public void setUp() throws Exception {
        matcher = new Matcher();
        clipLimit = 100;
        delta = 5;
    }
    
    @Test 
    public void testMatchNotModifyingTables() {
        int[] actual = new int[]{12, 55, 25, 110};
        assertTrue(matcher.match(actual, actual, clipLimit, delta));
        assertEquals(110, actual[3]);
        assertTrue(matcher.match(actual.clone(), actual, clipLimit, delta));
        assertEquals(110, actual[3]);
    }

    @Test
    public void testMatch() {

        int[] expected = new int[]{10, 50, 30, 98};

        int[] actual = new int[]{12, 55, 25, 110};

        assertTrue(matcher.match(expected, actual, clipLimit, delta));
        
        actual = new int[]{10, 60, 30, 98};
        assertTrue(!matcher.match(expected, actual, clipLimit, delta));

        actual = new int[]{10, 50, 30};
        assertTrue(!matcher.match(expected, actual, clipLimit, delta));
    }
}
