package arrays;

import java.util.Scanner;

public class SpanOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Span of the array is = " + span(arr));
    }

    private static int span(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max - min;
    }
}
