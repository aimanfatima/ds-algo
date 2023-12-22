package recursionandbacktracking;

public class AL_AllIndicesInAnArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 8, 5, 0, 2};
        int[] allIndices = allIndicesInAnArray(arr, 2, 0, 0);
        for (int i=0; i<allIndices.length; i++) {
            System.out.print(allIndices[i] + " ");
        }
    }

    private static int[] allIndicesInAnArray(int[] arr, int data, int index, int foundSoFar) {
        if (index == arr.length) {
            return new int[foundSoFar];
        }

        if (arr[index] == data) {
            int[] allIndices = allIndicesInAnArray(arr, data, index+1, foundSoFar + 1);
            allIndices[foundSoFar] = index;
            return allIndices;
        } else {
            int[] allIndices = allIndicesInAnArray(arr, data, index+1, foundSoFar);
            return allIndices;
        }
    }
}