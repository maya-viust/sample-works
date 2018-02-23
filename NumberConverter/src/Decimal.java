/**
 * Converts numbers to the correct decimal value
 *
 * author: Maya Viust
 * version 1.0
 */
public class Decimal extends Number {
    public static String toBin(String dec) {
        int input = Integer.parseInt(dec);
        String output = "";

        while (input > 0) {
            output = (input & 1) + output;
            input = input >> 1;
        }
        return output;
    }

    public static int toDec(String input) {
        return Integer.parseInt(input);
    }

    public static String toHex(String dec) {
        int input = Integer.parseInt(dec);
        String output = "";
        int fourBit = 0;

        while (input > 0) {
            fourBit = (input & 15);

            output = hexDigit(fourBit) + output;

            input = input >> 4;
        }

        return output;
    }
    public static String toOct(String dec) {
        int input = Integer.parseInt(dec);
        String output = "";

        while (input > 0) {
            output = (input & 7) + output;
            input = input >> 3;
        }
        return output;
    }
}
