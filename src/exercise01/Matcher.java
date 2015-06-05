package exercise01;

/**
 * Changes:
 * 
 * - check for length first, and check if the two tables aren't referencing the same object
 * - clone table "actual" so we don't modify the reference outside of this method
 * - clip also values of table "expected"
 * - moved checking deltas to one loop with clipping
 * 
 * @author kelu
 */
public class Matcher {

    public Matcher() {
    }

    public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

        // Check for length differences
        if (actual.length != expected.length) {
            return false;
        }
        
        // Check for references
        if (actual == expected) {
            return true;
        }
        
        expected = expected.clone();
        actual = actual.clone();
        
        
        for (int i = 0; i < actual.length; i++) {
            // Clip "too-large" values
            if (actual[i] > clipLimit) {
                actual[i] = clipLimit;
            }
            if (expected[i] > clipLimit) {
                expected[i] = clipLimit;
            }
            
            // Check that each entry within expected +/- delta
            if (Math.abs(expected[i] - actual[i]) > delta) {
                return false;
            }
        }
        
        return true;
    }
}
