package numbersSystem;

import java.util.Scanner;

public class ConvertDecimalToBaseB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int base = scanner.nextInt();

        int convertedNumber = convertDecimalToBaseB(number, base);
        System.out.println(convertedNumber);
    }

    public static int convertDecimalToBaseB(int number, int base) {
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
