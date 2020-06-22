public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder prefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; ++i) {
            String s = strs[i];
            int min = Math.min(prefix.length(), s.length());
            int commIndex = min;
            for (int ci = 0; ci < min; ++ci) {
                if (s.charAt(ci) != prefix.charAt(ci)) {
                    commIndex = ci;
                    break;
                }
            }
            prefix.delete(commIndex, prefix.length());
        }
        return prefix.toString();
    }

}
