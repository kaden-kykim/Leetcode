public class StringToInteger_atoi_8 {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        boolean isNegative = false;
        long result = 0;

        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c <= '9' && c >= '0') {
                result *= 10;
                result += c - '0';
                if (isNegative && -result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (!isNegative && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) ((isNegative) ? -result : result);
    }

}
