package stringstringbuilderandarraylists;

public class StringWithASCIIDifference {

    public static String stringWithASCIIDifference(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length()-1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);

            int diff = ch2 - ch1;
            sb.append(ch1);
            sb.append(diff);
        }
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringWithASCIIDifference("abdgca"));
    }
}
