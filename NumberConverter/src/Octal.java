/**
 * Converts numbers to the correct octal value
 */
public class Octal extends Number{
    public static String toBin(String input) {
        String output = "";

        for (int i = input.length() - 1; i >=0; i--) {
            output = zerofill(Decimal.toBin("" + Integer.parseInt(""
                    + input.charAt(i))), 3) + output;
        }
        return zeroTrim(output);
    }
    public static int toDec(String input) {
        int output = 0;
        int exp = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            output += Integer.parseInt(input.charAt(i) + "") << exp;
            exp += 3;
        }
        return output;
    }
    public static String toOct(String input) {
        return input;
    }
    public static String toHex(String input) {
        return Decimal.toHex("" + Octal.toDec(input));
    }
}
