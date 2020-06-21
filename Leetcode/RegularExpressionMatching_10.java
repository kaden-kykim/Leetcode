public class RegularExpressionMatching_10 {

    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) return true;

        int sLen = s.length();
        boolean[][] possible = new boolean[2][];
        possible[0] = new boolean[sLen + 1];
        possible[0][sLen] = true;

        for (int pIndex = p.length() - 1; pIndex >= 0; --pIndex) {
            possible[1] = possible[0];
            possible[0] = new boolean[sLen + 1];

            boolean containsStar = p.charAt(pIndex) == '*';
            char c = p.charAt((containsStar) ? --pIndex : pIndex);
            boolean isCDot = c == '.';
            boolean pos = false;
            for (int sIndex = sLen; sIndex >= 0; --sIndex) {
                if (possible[0][sIndex]) continue;
                if (containsStar) {
                    if (!possible[1][sIndex]) continue;
                    if (possible[1][sIndex]) possible[0][sIndex] = pos = true;
                    for (int i = sIndex; i >= 0; --i) {
                        if (i == sLen) continue;
                        if (isCDot || c == s.charAt(i) || possible[1][i]) possible[0][i] = pos = true;
                        else break;
                    }
                } else {
                    if (sIndex == sLen || !possible[1][sIndex + 1]) continue;
                    if (isCDot || c == s.charAt(sIndex)) possible[0][sIndex] = pos = true;
                }
            }
            if (!pos) break;
        }

        return possible[0][0];
    }

}
