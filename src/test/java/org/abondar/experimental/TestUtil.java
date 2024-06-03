package org.abondar.experimental;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtil {

    public static void verifyBooleanResult(boolean expected, boolean actual){
        if (expected){
            assertTrue(actual);
        } else {
            assertFalse(actual);
        }
    }
}
