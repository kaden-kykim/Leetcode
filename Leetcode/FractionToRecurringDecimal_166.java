import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();
        boolean isNeg = false;
        long num = numerator, den = denominator;
        if (num < 0) { isNeg = true; num = -num; }
        if (den < 0) { isNeg = !isNeg; den = -den; }
        result.append(num / den);
        long rem = (num % den) * 10;
        if (rem != 0) {
            result.append('.');
            int offset = result.length();
            Map<Long, Integer> map = new HashMap<>();
            while (rem != 0) {
                if (map.containsKey(rem)) {
                    result.insert(map.get(rem), "(");
                    result.append(')'); break;
                }
                map.put(rem, offset);
                while (rem < den) { rem *= 10; result.append(0); ++offset; }
                result.append(rem / den); ++offset;
                rem = (rem % den) * 10;
            }
        }
        if (isNeg) result.insert(0, '-');
        return result.toString();
    }

}
