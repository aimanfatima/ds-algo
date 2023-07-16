package basics;

import java.util.Scanner;

public class RotateANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        int digits = countNoOfDigits(num);

        if (k >= digits) {
            k = k % digits;
        } else if (k < 0) {
            k = k + digits;
        }
        int divisor = (int)Math.pow(10, k);
        int remainder = num % divisor;
        int quotient = num / divisor;
        System.out.println((remainder * (int)Math.pow(10, digits-k)) + quotient);
    }

    private static int countNoOfDigits(int n) {
        int digits = 0;
        while (n > 0) {
            n = n/10;
            digits++;
        }
        return digits;
    }
}
