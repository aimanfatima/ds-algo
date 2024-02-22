package stringstringbuilderandarraylists;

public class AllPalindromicSubstring {
    public static void main(String[] args) {
        // Print all the substring of the given string which are palindrome
        String s = "abccbc";

        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                String substr = s.substring(i,j);
                if (isPalindrome(substr)) {
                    System.out.println(substr);
                }
            }
        }
    }

    private static boolean isPalindrome(String substr) {
        boolean isPalindrome = true;
        int left = 0;
        int right = substr.length()-1;
        while(left < right) {
            if(substr.charAt(left) != substr.charAt(right)) {
                isPalindrome = false;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }
}
