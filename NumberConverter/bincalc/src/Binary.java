/**
 * Converts numbers to the correct binary
 */
public class Binary extends Number {
    public static String toBin(String input) {
        return input;
    }
    public static int toDec(String input) {
        int output = 0;
        int shift = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '1') {
                output += 1 << shift;
            }
            shift++;
        }
        return output;
    }

    public static String toHex(String input) {
        String output = "";
        while (input.length() >= 4) {
            output = hexDigit(Binary.toDec(input.substring(input.length() - 4))
                    + output);
            input = input.substring(0, input.length() - 4);
        }

        if (input.length() > 0) {
            output = Binary.toDec(input) + output;
        }
        return output;
    }

    public static String toOct(String input) {
        String output = "";
        while (input.length() >= 3) {
            output = Binary.toDec(input.substring(input.length() - 3)) + output;
            input = input.substring(0, input.length() - 3);
        }
        if (input.length() > 0) {
            output = toDec(input) + output;
        }
        return output;
    }
}
