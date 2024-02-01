package hashmaps;

import java.util.HashMap;

public class GetCommonElement {
    public static void main(String[] args) {
        int[] arr1 = {4,4,5,1,1,1,3,8,9,10};
        int[] arr2 = {10,8,1,3,6,7,8,4,4};

        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int i=0; i< arr1.length; i++) {
            hm.put(arr1[i], true);
        }

        for (int i=0; i<arr2.length; i++) {
            if (hm.containsKey(arr2[i]) && hm.get(arr2[i])) {
                System.out.print(arr2[i] + " ");
                hm.put(arr2[i], false);
            }
        }
    }
}
