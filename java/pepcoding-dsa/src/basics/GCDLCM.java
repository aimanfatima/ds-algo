package basics;

import java.util.Scanner;

public class GCDLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int dividend = Math.max(num1, num2);
        int divisor = Math.min(num1, num2);
        int remainder = dividend % divisor;

        while (remainder != 0 ) {
            dividend = divisor;
            divisor = remainder;
            remainder = dividend % divisor;
        }
        System.out.println("GCD is " + divisor);
        System.out.println("LCM is " + (num1 * num2)/divisor);
    }
}