import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    private List<String> result;
    private int length;

    public List<String> generateParenthesis(int n) {
        length = n * 2;
        result = new ArrayList<>();
        if (n == 0) return result;
        recGenParenthesis(0, new StringBuilder());
        return result;
    }

    private void recGenParenthesis(int index, StringBuilder stringBuilder) {
        stringBuilder.append('(');
        index++;
        if (length - stringBuilder.length() == index) {
            for (int i = 0; i < index; ++i) { stringBuilder.append(')'); }
            result.add(stringBuilder.toString());
            stringBuilder.delete(stringBuilder.length() - index, stringBuilder.length());
        } else {
            recGenParenthesis(index, stringBuilder);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        index--;
        stringBuilder.append(')');
        index--;
        if (index >= 0) { recGenParenthesis(index, stringBuilder); }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

}
