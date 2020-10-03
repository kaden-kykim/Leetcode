import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator_341 implements Iterator<Integer> {

    private final List<Integer> flattenNestedList = new ArrayList<>();
    private final int flattenSize;
    private int cursor = 0;

    public FlattenNestedListIterator_341(List<NestedInteger> nestedList) {
        helper(nestedList);
        flattenSize = flattenNestedList.size();
    }

    @Override
    public boolean hasNext() {
        return cursor < flattenSize;
    }

    @Override
    public Integer next() {
        return flattenNestedList.get(cursor++);
    }

    private void helper(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) flattenNestedList.add(nestedInteger.getInteger());
            else helper(nestedInteger.getList());
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
