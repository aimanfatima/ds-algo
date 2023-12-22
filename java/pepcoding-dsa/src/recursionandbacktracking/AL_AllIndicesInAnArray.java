package recursionandbacktracking;

public class AL_AllIndicesInAnArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 10, 2, 3, 4, 3, 10, 2, 3};
        int[] allIndices = allIndicesInAnArray(arr, 2, 0);
        for (int i=0; i<allIndices.length; i++) {
            System.out.print(allIndices[i] + " ");
        }
    }

    private static int[] allIndicesInAnArray(int[] arr, int data, int index) {
        if (index == arr.length) {
            return new int[0];
        }
        int[] smallerArray = allIndicesInAnArray(arr, data, index+1);
        if (arr[index] == data) {
            int[] newArray = new int[smallerArray.length + 1];
            newArray[0] = index;
            for (int i=1; i<newArray.length; i++) {
                newArray[i] = smallerArray[i-1];
            }
            return newArray;
        }
        return smallerArray;
    }
}
