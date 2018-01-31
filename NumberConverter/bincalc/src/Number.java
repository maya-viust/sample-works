/**
 * Created by maya v on 11/16/2017.
 */
public class Number {
    public static String hexDigit(int init) {
        if (init > 9) {
            return "" + (char) (init + 55);
        }
        return "" + init;
    }

    public static String hexDigit(String init) {
        return hexDigit(Integer.parseInt(init));
    }

    public static int unHexDigit(char input) {
        try {
            return Integer.parseInt(input + "");
        } catch (NumberFormatException nfe) {
            return input - 55;
        }
    }

    public static String zerofill(String input, int len) {
        if (input.length() < len) {
            while (input.length() < len) {
                input = "0" + input;
            }
        }
        return input;
    }

    public static String zeroTrim(String input) {
        while (input.charAt(0) == '0') {
            input = input.substring(1);
        }
        return input;
    }
}
