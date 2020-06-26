public class CountAndSay_38 {

    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        for (byte i = 1; i < n; ++i) {
            char[] chars = result.toString().toCharArray();
            result = new StringBuilder();
            char prev = '\0';
            byte repeat = 0;
            for (char cur : chars) {
                if (prev == '\0') { prev = cur; repeat = 1; }
                else if (prev == cur) ++repeat;
                else {
                    result.append(repeat); result.append(prev);
                    prev = cur; repeat = 1;
                }
            }
            result.append(repeat); result.append(prev);
        }
        return result.toString();
    }

}
