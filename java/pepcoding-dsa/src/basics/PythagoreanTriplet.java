package basics;

import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (b > a && b > c) {
            // swap a and b
            int temp = a;
            a = b;
            b = temp;
        } else if (c > a && c > b) {
            // swap a and c
            int temp = a;
            a = c;
            c = temp;
        }

        if (b*b + c*c == a*a) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
