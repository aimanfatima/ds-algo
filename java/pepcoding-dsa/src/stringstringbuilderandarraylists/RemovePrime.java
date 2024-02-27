package stringstringbuilderandarraylists;

import java.util.ArrayList;
import java.util.Arrays;

public class RemovePrime {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 12, 13, 15, 2, 23, 19, 1, 7, 20));

        // note - since this involves removal of elements we are gonna run the loop from right to left
        for (int i=arr.size()-1; i>=0; i--) {
            if (isPrime(arr.get(i))) {
                arr.remove(i);
            }
        }

        System.out.println(arr);
    }

    private static boolean isPrime(Integer num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i=2; i*i<num; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
