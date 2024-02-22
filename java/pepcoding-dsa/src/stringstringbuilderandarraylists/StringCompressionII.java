package stringstringbuilderandarraylists;

public class StringCompressionII {
    public static void main(String[] args) {
        // compress the given string to - a3b2c3d2ae2f
        String s = "aaabbcccddaeef";

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
                sb.append(s.charAt(i));
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        System.out.println(sb);

    }
}
