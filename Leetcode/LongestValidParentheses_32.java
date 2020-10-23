public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        int max = 0, count = 0, startIndex = 0, length = s.length();
        for (int i = 0; i < length; ++i) {
            if (chars[i] == '(') ++count; else --count;
            if (count < 0) { startIndex = i + 1; count = 0; }
            else if (count == 0) max = Math.max(max, i - startIndex + 1);
        }
        count = 0; startIndex = length - 1;
        for (int i = length - 1; i >= 0; --i) {
            if (chars[i] == ')') ++count; else --count;
            if (count < 0) { startIndex = i - 1; count = 0; }
            else if (count == 0) max = Math.max(max, startIndex - i + 1);
        }
        return max;
    }

}
