package stringstringbuilderandarraylists;

public class ToggleCase {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("pepCoDiNG");

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char uc = (char)('A' + ch - 'a');
                s.setCharAt(i, uc);
            } else {
                char lc = (char)('a' + ch - 'A');
                s.setCharAt(i, lc);
            }
        }
        System.out.println(s);
    }
}
