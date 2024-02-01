package hashmaps;

import java.util.HashMap;

public class MaximumFrequency {
    public static void main(String[] args) {
        String s = "abracadabra";
        HashMap<Character, Integer> hm  = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else{
                int val = hm.get(c);
                hm.put(c, val+1);
            }
        }

        Character result = null;
        int max = Integer.MIN_VALUE;
        for (Character key : hm.keySet()) {
            if (hm.get(key) > max) {
                result = key;
                max = hm.get(key);
            }
        }
        System.out.println(hm);
        System.out.println(result);
    }
}
