package recursionandbacktracking;

public class AH_DisplayArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        displayArray(arr, 0);
    }

    public static void displayArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index]);
        displayArray(arr, index + 1);
    }
}
