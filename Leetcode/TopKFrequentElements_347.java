import java.util.*;

public class TopKFrequentElements_347 {

    public int[] topKFrequentOpt2(int[] nums, int k) {
        int length = nums.length;
        int[] keys = new int[length], values = new int[length];
        for (int num : nums) {
            int hash = (num & 0x7fffffff) % length;
            while (keys[hash] != num && values[hash] > 0) ++hash;
            keys[hash] = num; ++values[hash];
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] sortedList = new List[length + 1];
        for (int i = 0; i < length; ++i) {
            int value = values[i];
            if (value > 0) {
                if (sortedList[value] == null) sortedList[value] = new ArrayList<>();
                sortedList[value].add(keys[i]);
            }
        }

        int[] result = new int[k];
        for (int i = sortedList.length - 1; i >= 0 && k > 0; --i) {
            if (sortedList[i] != null) {
                for (int num : sortedList[i]) {
                    result[--k] = num;
                    if (k == 0) return result;
                }
            }
        }
        return result;
    }

    public int[] topKFrequentOpt(int[] nums, int k) {
        Queue<int[]> pQueue = new PriorityQueue<>(k + 1, Comparator.comparingInt(val -> val[1]));
        Arrays.sort(nums);
        int key = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (key == nums[i]) ++count;
            else {
                offer(pQueue, new int[]{key, count}, k);
                key = nums[i]; count = 1;
            }
        }
        offer(pQueue, new int[]{key, count}, k);

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) result[i] = pQueue.poll()[0];
        return result;
    }

    private void offer(Queue<int[]> pQueue, int[] val, int k) {
        pQueue.offer(val);
        if (k < pQueue.size()) pQueue.poll();
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Queue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pQueue.size() < k) pQueue.offer(entry);
            else if (pQueue.peek().getValue() < entry.getValue()) { pQueue.poll(); pQueue.offer(entry); }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) result[i] = pQueue.poll().getKey();
        return result;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Queue<Integer> pQueue = new PriorityQueue<>(k + 1, Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            pQueue.offer(key);
            if (k < pQueue.size()) pQueue.poll();
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) result[i] = pQueue.poll();
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        int[] result = new int[k];
        for (int i = 0, j = list.size() - 1; i < k; ++i, --j) result[i] = list.get(j).getKey();
        return result;
    }

}
