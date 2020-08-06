import java.util.Stack;

public class MinStack_155 {

    private final Stack<int[]> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public MinStack_155() {}
    public void push(int x) { stack.push(new int[]{x, min}); min = Math.min(min, x); }
    public void pop() { min = stack.pop()[1]; }
    public int top() { return stack.peek()[0]; }
    public int getMin() { return min; }

}
