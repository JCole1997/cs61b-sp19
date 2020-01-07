import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FlikTest {
    @Test
    public void fliktest() {
        Integer a = 1;
        Integer b = 1;
        assertTrue(Flik.isSameNumber(a, b));

        a = 128;
        b = 128;
        assertTrue(Flik.isSameNumber(a, b));
    }
}
