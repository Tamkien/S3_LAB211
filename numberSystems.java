import java.math.BigInteger;
import java.util.Scanner;

/*
    Convert base number systems (bin, dex, hex)
    Function details:

    1. Main
    1.1 Show menu
    1.2 Get input, output system
    1.3 Get input value
    1.4 Process (input, output, value)

    2. Process
    2.1 calculate
    2.2 print result

    3. Bin to Dec
    4. Dec to Bin
    5. Dec to Hex
    6. Hex to Dec

    7. Print out
 */
public class numberSystems {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (; ; ){
            int inputSystem = getSystem("input");
            int outputSystem = getSystem("output");
            String inputValue = getInputValue();
            String result = process(inputSystem, outputSystem, inputValue);
            print(result);
        }
    }

    //Get input, output system
    private static int getSystem(String type) {
        //infinite loops so user must input correctly (a choice) to continue
        for (; ; ) {
            try {
                System.out.println("Please choose the base number " + type + ":");
                System.out.println("1. Binary");
                System.out.println("2. Decimal");
                System.out.println("3. Hexadecimal");
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input == 1 || input == 2 || input == 3) {
                    return input;
                } else System.out.println("Please choose 1, 2, or 3");
            } catch (NumberFormatException e) {
                System.out.println("Please choose 1, 2, or 3");
            } catch (Exception e) {
                System.out.println("Error! Reason: " + e);
            }
        }
    }

    private static String getInputValue() {
        //infinite loops so user must input correctly (a string) to continue
        for (; ; ) {
            try {
                System.out.println("Please input a number:");

                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                }
                System.out.println("Please enter something!");
            } catch (Exception e) {
                System.out.println("Error! Reason: " + e);
            }
        }
    }

    private static String process(int inputSystem, int outputSystem, String inputValue) {
        switch (inputSystem) {
            case 1:
                if (isBinary(inputValue)) {
                    switch (outputSystem) {
                        case 2:
                            return binToDec(inputValue);
                        case 3:
                            return decToHex(binToDec(inputValue));
                        default:
                            System.out.println("Unnecessary to convert!");
                    }
                } else {
                    System.out.println("Input is not a binary number!");
                    return null;
                }

            case 2:
                if (isDecimal(inputValue)) {
                    switch (outputSystem) {
                        case 1:
                            return decToBin(inputValue);
                        case 3:
                            return decToHex(inputValue);
                        default:
                            System.out.println("Unnecessary to convert!");
                    }
                } else {
                    System.out.println("Input is not a decimal number!");
                    return null;
                }

            case 3:
                if (isHexadecimal(inputValue)) {
                    switch (outputSystem) {
                        case 1:
                            return decToBin(hexToDec(inputValue));
                        case 2:
                            return hexToDec(inputValue);
                        default:
                            System.out.println("Unnecessary to convert!");
                    }
                } else {
                    System.out.println("Input is not a Hexadecimal number!");
                    return null;
                }
            default:
                return null;
        }
    }

    private static boolean isBinary(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++)
            if ((int) inputValue.charAt(i) != 48 && (int) inputValue.charAt(i) != 49) return false;
        return true;
    }

    private static boolean isDecimal(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++)
            if ((int) inputValue.charAt(i) < 48 || (int) inputValue.charAt(i) > 57)
                return false;
        return true;
    }

    private static boolean isHexadecimal(String inputValue) {
        inputValue = inputValue.toUpperCase();
        for (int i = 0; i < inputValue.length(); i++) {
            if (!(((int) inputValue.charAt(i) >= 48 && (int) inputValue.charAt(i) <= 57) || ((int) inputValue.charAt(i) >= 65 && (int) inputValue.charAt(i) <= 70))) {
                return false;
            }
        }
        return true;
    }


    private static String hexToDec(String inputValue) {
        System.out.println("Hex to Dec");
        long result = 0;
        inputValue = inputValue.toUpperCase();
        int length = inputValue.length();
        for (int i = 0; i < length; i++) {
            char thisChar = inputValue.charAt(i);
            long difference;
            if ((int) thisChar < 60) difference = 48;
            else difference = 55;
            System.out.print(((long) thisChar - difference) + "*" + 16 + "^" + (length - i - 1) + " + ");
            result += ((long) thisChar - difference) * (long)Math.pow(16, length - i - 1);
        }
        System.out.println();
        System.out.println(result);
        return Long.toString(result);
    }

    private static String decToBin(String inputValue) {
        System.out.println("Dec to Bin");
        StringBuilder result = new StringBuilder();
        long decValue = Long.parseLong(inputValue);
        while (decValue != 0) {
            System.out.println(decValue + " / 2 = " + decValue / 2 + " remainder " + decValue % 2);
            result.append(decValue % 2);
            decValue /= 2;
        }
        System.out.println(result.reverse().toString());
        return result.toString();
    }

    private static String decToHex(String inputValue) {
        System.out.println("Dec to Hex");
        StringBuilder result = new StringBuilder();
        long decValue = Long.parseLong(inputValue);
        while (decValue != 0) {
            long reminder = decValue % 16;
            if (reminder < 10) {
                System.out.println(decValue + " / 16 = " + decValue / 16 + " remainder " + reminder);
                result.append(reminder);
            } else {
                System.out.println(decValue + " / 16 = " + decValue / 16 + " remainder " + (char) (reminder + 55));
                result.append((char) (reminder + 55));
            }
            decValue /= 16;
        }
        System.out.println(result.reverse().toString());
        return result.toString();
    }

    private static String binToDec(String inputValue) {
        System.out.println("Bin to Dec");
        long result = 0;
        for (int i = 0; i < inputValue.length(); i++) {
            System.out.print(((inputValue.charAt(i)) - 48) + "*" + 2 + "^" + (inputValue.length() - i - 1) + " + ");
            result += ((int) (inputValue.charAt(i)) - 48) * Math.pow(2, inputValue.length() - i - 1);
        }
        System.out.println();
        System.out.println(result);
        return Long.toString(result);
    }

    private static void print(String result) {
        System.out.println("Result: " + result);
    }
}
