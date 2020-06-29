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
            if (pChar == '*') {
                while (pi != p.length() - 1 && p.charAt(pi + 1) == '*') pi++;
                if (pi == p.length() - 1) return true;
            }
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

}
