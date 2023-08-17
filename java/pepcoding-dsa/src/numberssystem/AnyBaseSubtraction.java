package numberssystem;

import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int base = scanner.nextInt();

        int sum = anyBaseSubtraction(num1, num2, base);
        System.out.println(sum);
    }

    private static int anyBaseSubtraction(int num1, int num2, int base) {
        int result = 0;
        int power = 1;
        int carry = 0;

        while (num1 > 0 || num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            int ans = digit1 - digit2 + carry;
            num1 = num1 / 10;
            num2 = num2 / 10;
            if (ans < 0) {
                digit1 = digit1 + base;
                num1 = num1 - 1;
                ans = digit1 - digit2;
            }
            result  = result + (ans * power);
            power = power * 10;

        }

        return result;
    }
}
