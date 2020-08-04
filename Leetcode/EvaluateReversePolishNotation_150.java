import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.length() == 1 && token.charAt(0) < '0') {
                Integer op2 = stack.pop(), op1 = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(op1 + op2); break;
                    case '-': stack.push(op1 - op2); break;
                    case '*': stack.push(op1 * op2); break;
                    case '/': stack.push(op1 / op2); break;
                }
            } else { stack.push(Integer.parseInt(token)); }
        }
        return stack.pop();
    }

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer op1, op2;
        for (String token : tokens) {
            if (token.length() == 1) {
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(stack.pop() + stack.pop()); break;
                    case '*':
                        stack.push(stack.pop() * stack.pop()); break;
                    case '-':
                        op2 = stack.pop(); op1 = stack.pop();
                        stack.push(op1 - op2); break;
                    case '/':
                        op2 = stack.pop(); op1 = stack.pop();
                        stack.push(op1 / op2); break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
