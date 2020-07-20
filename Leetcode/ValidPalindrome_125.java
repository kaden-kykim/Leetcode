public class ValidPalindrome_125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        char[] chars = s.toLowerCase().toCharArray();
        int start = -1, end = chars.length;
        char sChar, eChar;
        while (++start <= --end) {
            while (isNotAlphanumericChar(sChar = chars[start])) {
                if (++start >= chars.length) return true;
            }
            while (isNotAlphanumericChar(eChar = chars[end])) {
                if (--end < 0) return true;
            }
            if (sChar != eChar) return false;
        }
        return true;
    }

    private boolean isNotAlphanumericChar(char c) {
        return ((c < 'a' || 'z' < c) && (c < '0' || '9' < c));
    }

}
