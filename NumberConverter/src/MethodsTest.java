import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class tests every method in the Decimal, Binary, Hex, Octal,
 * and Number classes
 */
public class MethodsTest {
    private static final int TIMEOUT = 200;
    private static String dec;
    private static String bin;
    private static String hex;
    private static String oct;

    @BeforeClass
    public static void setUp() {
        dec = "34";
        bin = "10011";
        hex = "3A4";
        oct = "733";
    }

    @Test(timeout = TIMEOUT)
    public void binaryClass() {
        assertEquals("10011",Binary.toBin(bin));
        assertEquals(19, Binary.toDec(bin));
        assertEquals("13", Binary.toHex(bin));
        assertEquals("23", Binary.toOct(bin));
    }

    @Test(timeout = TIMEOUT)
    public void decimalClass() {
        assertEquals("100010",Decimal.toBin(dec));
        assertEquals(34, Decimal.toDec(dec));
        assertEquals("22", Decimal.toHex(dec));
        assertEquals("42", Decimal.toOct(dec));
    }

    @Test(timeout = TIMEOUT)
    public void hexClass() {
        assertEquals("1110100100", Hex.toBin(hex));
        assertEquals(932, Hex.toDec(hex));
        assertEquals("3A4", Hex.toHex(hex));
        assertEquals("1644", Hex.toOct(hex));
    }

    @Test(timeout = TIMEOUT)
    public void octalClass() {
        assertEquals("111011011", Octal.toBin(oct));
        assertEquals(475, Octal.toDec(oct));
        assertEquals("1DB", Octal.toHex(oct));
        assertEquals("733", Octal.toOct(oct));
    }
}