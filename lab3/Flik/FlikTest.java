import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class FlikTest {
        /** Tests Flik*/
        @Test
        public void testFlik() {
            int a = 5;
            int b = -8;
            boolean expected = false;
            boolean actual = Flik.isSameNumber(a, b);
            assertEquals(expected, actual);

            b = 5;
            assertTrue(Flik.isSameNumber(a, b));
        }
}
