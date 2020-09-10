import java.util.*;

public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int curMax = nums[0], index = 0, left = 0, right = 0;

        while (left <= nums.length - k) {
            if (right - left < k - 1) {
                if (nums[++right] > curMax) curMax = nums[right];
            } else if (right - left == k - 1) {
                result[index++] = curMax;
                if (left == nums.length - 1) break;
                if (nums[left++] == curMax) {
                    curMax = nums[left];
                    for (int i = left; i <= right; i++) if (nums[i] > curMax) curMax = nums[i];
                }
            }
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        Queue<Integer> delPQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (int i = 0; i < k; ++i) pQueue.offer(nums[i]);
        result[0] = pQueue.peek();
        for (int del = 0, ins = k; ins < nums.length; ++del, ++ins) {
            if (nums[del] == pQueue.peek()) {
                pQueue.poll();
                while (!pQueue.isEmpty() && pQueue.peek().equals(delPQueue.peek())) {
                    pQueue.poll(); delPQueue.poll();
                }
            }
            else delPQueue.offer(nums[del]);
            pQueue.offer(nums[ins]);
            result[del + 1] = pQueue.peek();
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        List<Integer> kList = new ArrayList<>();
        for (int i = 0; i < k; ++i) kList.add(nums[i]);
        Collections.sort(kList);
        result[0] = kList.get(k - 1);
        for (int del = 0, ins = k; ins < nums.length; ++ins) {
            kList.remove(Collections.binarySearch(kList, nums[del]));
            int idx = Collections.binarySearch(kList, nums[ins]);
            kList.add(idx < 0 ? -idx - 1 : idx, nums[ins]);
            result[++del] = kList.get(k - 1);
        }
        return result;
    }

}
