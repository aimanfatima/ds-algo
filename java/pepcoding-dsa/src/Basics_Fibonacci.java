import java.util.Scanner;

public class Basics_Fibonacci {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int first = 0;
        int second = 1;
        for (int i=1; i<=n ; i++) {
            if (i==1) {
                System.out.print(first + " ");
            } else if (i==2) {
                System.out.print(second + " ");
            } else {
                int next = first + second;
                first = second;
                second = next;
                System.out.print(next + " ");
            }
        }
    }
}
