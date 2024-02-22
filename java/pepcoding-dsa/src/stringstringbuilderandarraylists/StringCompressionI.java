package stringstringbuilderandarraylists;

public class StringCompressionI {
    public static void main(String[] args) {
        // compress the given string to - abcdaef
        String s = "aaabbcccddaeef";

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i-1)) {

            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        System.out.println(sb);
    }
}
