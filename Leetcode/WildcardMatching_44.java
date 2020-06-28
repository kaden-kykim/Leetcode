public class WildcardMatching_44 {

    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) return true;
        int sLength = s.length();
        boolean[][] possible = new boolean[2][];
        possible[1] = new boolean[sLength + 1];
        possible[1][0] = true;

        for (int pi = 0; pi < p.length(); ++pi) {
            possible[0] = possible[1];
            possible[1] = new boolean[sLength + 1];

            boolean pos = false;
            char pChar = p.charAt(pi);
            for (int si = 0; si <= sLength; ++si) {
                if (!possible[0][si]) continue;
                if (pChar == '*') {
                    for (int i = si; i <= sLength; ++i) {
                        possible[1][i] = pos = true;
                    }
                } else if (si != sLength && (pChar == '?' || pChar == s.charAt(si))) {
                    possible[1][si + 1] = pos = true;
                }
            }
            if (!pos) break;
        }

        return possible[1][sLength];
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching_44().isMatch("aa", "aa"));
        System.out.println(new WildcardMatching_44().isMatch("", "*"));
        System.out.println(new WildcardMatching_44().isMatch("aa", "a"));
        System.out.println(new WildcardMatching_44().isMatch("aa", "*"));
        System.out.println(new WildcardMatching_44().isMatch("cb", "?a"));
        System.out.println(new WildcardMatching_44().isMatch("adceb", "*a*b"));
        System.out.println(new WildcardMatching_44().isMatch("acdcb", "a*c?b"));
    }

}
