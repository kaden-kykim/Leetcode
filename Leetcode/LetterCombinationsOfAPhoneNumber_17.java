import java.util.*;

public class LetterCombinationsOfAPhoneNumber_17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); ++i) {
            switch (digits.charAt(i)) {
                case '2': list.add(new char[]{'a', 'b', 'c'}); break;
                case '3': list.add(new char[]{'d', 'e', 'f'}); break;
                case '4': list.add(new char[]{'g', 'h', 'i'}); break;
                case '5': list.add(new char[]{'j', 'k', 'l'}); break;
                case '6': list.add(new char[]{'m', 'n', 'o'}); break;
                case '7': list.add(new char[]{'p', 'q', 'r', 's'}); break;
                case '8': list.add(new char[]{'t', 'u', 'v'}); break;
                case '9': list.add(new char[]{'w', 'x', 'y', 'z'}); break;
            }
        }

        StringBuilder sb = new StringBuilder();
        recStringBuilder(sb, list, result);

        return result;
    }

    private void recStringBuilder(StringBuilder stringBuilder, List<char[]> list, List<String> result) {
        char[] curList = list.remove(0);
        for (char c: curList) {
            stringBuilder.append(c);
            if (list.isEmpty()) result.add(stringBuilder.toString());
            else recStringBuilder(stringBuilder, list, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        list.add(0, curList);
    }

}
