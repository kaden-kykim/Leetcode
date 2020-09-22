import java.util.*;

public class FindMedianFromDataStream_295 {

    private final List<Integer> list;
    private final Queue<Integer> minHeap, maxHeap;

    private int dataSize = 0;

    public FindMedianFromDataStream_295() {
        list = new ArrayList<>();
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (dataSize == 0) minHeap.offer(num);
        else if (dataSize % 2 == 0) (minHeap.peek() <= num ? minHeap : maxHeap).offer(num);
        else {
            if (maxHeap.size() < minHeap.size()) {
                if (num < minHeap.peek()) maxHeap.offer(num);
                else { maxHeap.offer(minHeap.poll()); minHeap.offer(num); }
            } else {
                if (maxHeap.peek() < num) minHeap.offer(num);
                else { minHeap.offer(maxHeap.poll()); maxHeap.offer(num); }
            }
        }
        ++dataSize;
    }

    public double findMedian() {
        return dataSize % 2 == 0
                ? (minHeap.peek() + maxHeap.peek()) / 2.0
                : maxHeap.size() < minHeap.size() ? minHeap.peek() : maxHeap.peek();
    }

    public void addNum1(int num) {
        int index = Collections.binarySearch(list, num);
        list.add(index >= 0 ? index : -index - 1, num);
    }

    public double findMedian1() {
        int size = list.size(), half = (size - 1) >> 1;
        if (size == 0) return 0;
        return size % 2 == 0 ? (list.get(half) + list.get(half + 1)) / 2.0 : list.get(half);
    }

}
