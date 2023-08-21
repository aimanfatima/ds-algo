package arrays;

import java.util.Scanner;

public class FindElementInAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int element = scanner.nextInt();
        System.out.println(indexOfElement(arr, element));
    }

    private static int indexOfElement(int[] arr, int element) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
