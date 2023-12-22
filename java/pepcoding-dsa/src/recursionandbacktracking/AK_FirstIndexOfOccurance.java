package recursionandbacktracking;

public class AK_FirstIndexOfOccurance {
    public static void main(String[] args) {
        int[] arr = {99,3,9,8,7,6,4,12,7,3,3};
        System.out.println(firstIndexOfOccurance(arr, 3 , 0));
        System.out.println(lastIndexOfOccurance(arr, 3, 0));
    }
    private static int firstIndexOfOccurance(int[] arr, int num, int index) {
        if (arr[index] == num) {
            return index;
        }

        if (index == arr.length-1) {
            return -1;
        }
        return firstIndexOfOccurance(arr, num, index+1);
    }

    private static int lastIndexOfOccurance(int[] arr, int num, int index) {
        if (index == arr.length) {
            return -1;
        }
        int resultInSmallerArray = lastIndexOfOccurance(arr, num, index+1);
        if (resultInSmallerArray == -1 && arr[index] == num) {
            return index;
        } else {
            return  resultInSmallerArray;
        }
    }
}
