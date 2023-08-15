package numberssystem;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int inputBase = scanner.nextInt();
        int outputBase = scanner.nextInt();

        int toDecimal = convertAnyBaseToDecimal(number, inputBase);
        int result = convertDecimalToBaseB(toDecimal, outputBase);
        System.out.println(result);
    }

    private static int convertAnyBaseToDecimal(int number, int inputBase) {
        int result = 0;
        int power = 1;

        while (number > 0) {
            int remainder = number % 10;
            result += remainder * power;

            power = power * inputBase;
            number = number / 10;
        }

        return result;
    }

    private static int convertDecimalToBaseB(int number, int base) {
        int convertedNumber = 0;
        int multiplicationFactor = 1;

        while (number > 0) {
            int remainder = number % base;

            convertedNumber += remainder * multiplicationFactor;
            multiplicationFactor = multiplicationFactor * 10;

            number = number / base;
        }
        return convertedNumber;
    }
}
