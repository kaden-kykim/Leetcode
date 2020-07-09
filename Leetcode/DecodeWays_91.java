public class DecodeWays_91 {

    public int numDecodings(String s) {
        char[] sChars = s.toCharArray();
        int[] dDecode = new int[s.length()];
        int numDecode = 1;
        int prevChInt = 0, secPrevChInt = 0;
        for (int i = 0; i < s.length(); ++i) {
            int chInt = sChars[i] - '0';
            if ((chInt >= 1 && chInt <= 6 && (prevChInt == 1 || prevChInt == 2))
                    || (chInt >= 7 && chInt <= 9 && prevChInt == 1))
                numDecode += (i >= 2) ? dDecode[i - 2] : 1;
            else if (chInt == 0) {
                if (prevChInt != 1 && prevChInt != 2) return 0;
                if (secPrevChInt == 1 || secPrevChInt == 2)
                    numDecode -= (i >= 3) ? dDecode[i - 3] : 1;
            }
            secPrevChInt = prevChInt;
            prevChInt = chInt;
            dDecode[i] = numDecode;
        }
        return numDecode;
    }

}
