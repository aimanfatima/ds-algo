package numberssystem;

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputBase = scanner.nextInt();
        int inputNumber = scanner.nextInt();

        int convertedBaseTen = convertAnyBaseToDecimal(inputNumber, inputBase);
        System.out.println(convertedBaseTen);
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
}
