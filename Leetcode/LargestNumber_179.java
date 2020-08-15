import java.util.Arrays;

public class LargestNumber_179 {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int length = nums.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; ++i)
            strings[i] = ((Integer) nums[i]).toString();
        Arrays.sort(strings, (a, b) -> {
            int lenA = a.length(), lenB = b.length();
            if (lenA < lenB) {
                StringBuilder sb = new StringBuilder(a);
                while (sb.length() != lenB) sb.append(a.charAt(0));
                if (sb.toString().equals(b)) return (a + b).compareTo(b + a);
                return sb.toString().compareTo(b);
            } else if (lenB < lenA) {
                StringBuilder sb = new StringBuilder(b);
                while (sb.length() != lenA) sb.append(b.charAt(0));
                if (a.equals(sb.toString())) return (a + b).compareTo(b + a);
                return a.compareTo(sb.toString());
            }
            return a.compareTo(b);
        });
        StringBuilder result = new StringBuilder();
        for (int i = length - 1; i >= 0; --i) {
            if (result.length() == 0 && strings[i].equals("0")) continue;
            result.append(strings[i]);
        }
        return (result.length() != 0) ? result.toString() : "0";
    }

    public String largestNumber1(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int length = nums.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; ++i)
            strings[i] = ((Integer) nums[i]).toString();
        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder result = new StringBuilder();
        for (int i = length - 1; i >= 0; --i) {
            if (result.length() == 0 && strings[i].equals("0")) continue;
            result.append(strings[i]);
        }
        return (result.length() != 0) ? result.toString() : "0";
    }

}
