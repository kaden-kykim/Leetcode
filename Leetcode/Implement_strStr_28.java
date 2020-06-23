public class Implement_strStr_28 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.isEmpty()) return -1;
        int hLen = haystack.length(), nLen = needle.length();
        int[] failArray = failureFunction(needle);
        int cur = 0, index = 0;
        while (cur < hLen) {
            if (haystack.charAt(cur) == needle.charAt(index)) {
                if (index == nLen - 1) { return cur - index; }
                else { ++cur; ++index; }
            } else {
                if (index > 0) { index = failArray[index - 1]; }
                else { ++cur; }
            }
        }
        return -1;
    }

    private int[] failureFunction(String needle) {
        int length = needle.length();
        int[] failArray = new int[needle.length()];
        int cur = 1, index = 0;
        while (cur < length) {
            if (needle.charAt(cur) == needle.charAt(index)) { failArray[cur++] = index++ + 1; }
            else if (index > 0) { index = failArray[index - 1]; }
            else { failArray[cur++] = 0; }
        }
        return failArray;
    }

}
