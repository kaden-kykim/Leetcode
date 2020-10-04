public class ReverseString_344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) { char tmp = s[i]; s[i] = s[j]; s[j] = tmp; ++i; --j; }
    }

    public void reverseString1(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; ++i, --j) {
            char tmp = s[i]; s[i] = s[j]; s[j] = tmp;
        }
    }

}
