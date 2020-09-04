import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII_227 {

    public int calculate(String s) {
        List<String> order = new ArrayList<>();
        List<Character> opOrder = new ArrayList<Character>() {{ add('+'); }};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (ch == '+' || ch == '-') {
                order.add(sb.toString()); opOrder.add(ch);
                sb = new StringBuilder();
            } else sb.append(ch);
        }
        order.add(sb.toString());

        int[] operands = new int[order.size()];
        for (int i = 0; i < order.size(); ++i) operands[i] = helper(order.get(i));
        int result = 0;
        for (int i = 0; i < operands.length; ++i) {
            switch (opOrder.get(i)) {
                case '+': result += operands[i]; break;
                case '-': result -= operands[i]; break;
            }
        }
        return result;
    }

    private int helper(String s) {
        int val = 0, tmp = 0;
        char op = '.';
        for (char ch : s.toCharArray()) {
            if (ch <= '9' && ch >= '0') { val *= 10; val += ch - '0'; }
            else {
                if (op == '.') tmp = val;
                else switch (op) { case '*': tmp *= val; break; case '/': tmp /= val; break; }
                val = 0; op = ch;
            }
        }
        if (op == '.') return val;
        switch (op) {
            case '*': tmp *= val; break;
            case '/': tmp /= val; break;
        }
        return tmp;
    }

    public int calculate1(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int operand = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            if (ch <= '9' && ch >= '0') { operand *= 10; operand += ch - '0'; }
            else {
                operands.push(operand);
                operand = 0;
                if (!operators.empty()) {
                    char op = operators.peek();
                    if (op == '-') {
                        operators.pop();
                        operators.push('+');
                        operands.push(-operands.pop());
                    }
                    if (op == '*' || op == '/' || ch == '+' || ch == '-') helper1(operands, operators);
                }
                operators.push(ch);
            }
        }
        operands.push(operand);
        while (!operators.empty())
            helper1(operands, operators);
        return operands.pop();
    }

    private void helper1(Stack<Integer> operands, Stack<Character> operators) {
        int rhs = operands.pop();
        switch (operators.pop()) {
            case '+': operands.push(operands.pop() + rhs); break;
            case '-': operands.push(operands.pop() - rhs); break;
            case '*': operands.push(operands.pop() * rhs); break;
            case '/': operands.push(operands.pop() / rhs); break;
        }
    }

}
