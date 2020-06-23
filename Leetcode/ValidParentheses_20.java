import java.util.Stack;

public class ValidParentheses_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
            }
            if (stack.size() == 0) return false;
            switch (c) {
                case ')': if (stack.pop() != '(') return false; break;
                case '}': if (stack.pop() != '{') return false; break;
                case ']': if (stack.pop() != '[') return false; break;
            }
        }
        return stack.size() == 0;
    }

}
