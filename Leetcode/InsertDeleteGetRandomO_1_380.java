import java.util.*;

public class InsertDeleteGetRandomO_1_380 {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO_1_380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int valIndex = map.remove(val), lastVal = list.remove(list.size() - 1);
        if (lastVal != val) {
            list.set(valIndex, lastVal);
            map.put(lastVal, valIndex);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
