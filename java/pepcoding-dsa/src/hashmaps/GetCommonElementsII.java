package hashmaps;

import java.util.HashMap;

public class GetCommonElementsII {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,3,5};
        int[] arr2 = {1,1,1,2,2,4,5};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<arr1.length; i++) {
            int val = arr1[i];
            if (hm.containsKey(val)) {
                hm.put(val, hm.get(val) + 1);
            } else {
                hm.put(val, 1);
            }
        }

        for (int i=0; i<arr2.length; i++) {
            int val = arr2[i];
            if (hm.containsKey(val) && hm.get(val) > 0) {
                System.out.println(val + " ");
                hm.put(val, hm.get(val)-1);
            }
        }
    }
}
