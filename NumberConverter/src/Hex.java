/**
 * Created by maya v on 9/18/2017.
 */
public class Hex extends Number {
    public static String toBin(String input) {
        String output = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            output = zerofill(Decimal.toBin("" + unHexDigit(input.charAt(i))), 4)
                    + output;
        }
        return zeroTrim(output);
    }
    public static int toDec(String input) {
        int output = 0;
        int exp = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            output += unHexDigit(input.charAt(i)) << exp;
            exp += 4;
        }
        return output;
    }
    public static String toHex (String input) {
        return input;
    }
    public static String toOct(String input) {
        return Decimal.toOct(toDec(input) + "");
    }
}
