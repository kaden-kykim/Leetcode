import java.util.*;

public class TheSkylineProblem_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return result;
        for (int[] building : buildings) merge(building, result);
        int prevHeight = -1;
        for (int i = 0; i < result.size(); ++i) {
            int height = result.get(i).get(1);
            if (prevHeight == height) result.remove(i--);
            else prevHeight = height;
        }
        List<Integer> last = result.remove(result.size() - 1);
        result.add(Arrays.asList(last.get(0), 0));
        return result;
    }

    private void merge(int[] building, List<List<Integer>> result) {
        List<Integer> lElem = Arrays.asList(building[0], building[2]);
        int size = result.size();
        if (size == 0) {
            result.add(lElem); result.add(Arrays.asList(building[1], 0));
        } else {
            int lIndex = Collections.binarySearch(result, lElem, Comparator.comparingInt(o -> o.get(0)));
            if (lIndex == -size - 1) result.add(lElem);
            else {
                boolean isMax = false;
                int prevHeight;
                if (lIndex >= 0) {
                    prevHeight = result.get(lIndex).get(1);
                    if (prevHeight <= building[2]) {
                        isMax = true; result.remove(lIndex); result.add(lIndex++, lElem);
                    }
                } else {
                    lIndex = -lIndex - 1;
                    prevHeight = result.get(lIndex - 1).get(1);
                    if (prevHeight < building[2]) {
                        isMax = true; result.add(lIndex++, lElem);
                    }
                }
                while (lIndex < result.size()) {
                    List<Integer> curElem = result.get(lIndex);
                    if (building[1] < curElem.get(0)) {
                        if (isMax) result.add(lIndex, Arrays.asList(building[1], prevHeight));
                        break;
                    }
                    prevHeight = curElem.get(1);
                    if (isMax) result.remove(lIndex--);
                    else if (prevHeight < building[2]) {
                        isMax = true;
                        result.remove(lIndex); result.add(lIndex, Arrays.asList(curElem.get(0), building[2]));
                    }
                    ++lIndex;
                }
            }
            if (result.get(result.size() - 1).get(0) < building[1]) result.add(Arrays.asList(building[1], 0));
        }
    }

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return result;

        Set<Integer> pointSet = new HashSet<>(buildings.length * 2);
        List<Integer> points = new ArrayList<>();
        for (int[] building : buildings) {
            if (!pointSet.contains(building[0])) { pointSet.add(building[0]); points.add(building[0]); }
            if (!pointSet.contains(building[1])) { pointSet.add(building[1]); points.add(building[1]); }
        }
        Collections.sort(points);

        int size = points.size();
        int[] heights = new int[size];
        for (int[] building : buildings) {
            int height = building[2];
            int lIndex = Collections.binarySearch(points, building[0]);
            int rIndex = Collections.binarySearch(points, building[1]);
            for (int i = lIndex; i < rIndex; ++i)
                if (heights[i] < height) heights[i] = height;
        }

        int curHeight = -1;
        for (int i = 0; i < size; ++i) {
            if (heights[i] == curHeight) continue;
            curHeight = heights[i];
            List<Integer> bElem = new ArrayList<>();
            bElem.add(points.get(i)); bElem.add(heights[i]);
            result.add(bElem);
        }
        return result;
    }

    public List<List<Integer>> getSkylineRef(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return result;
        int length = buildings.length;
        Queue<int[]> pQueue = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        int x = buildings[0][0], next = 0;
        pQueue.offer(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0});

        while (x != Integer.MAX_VALUE || next < length || pQueue.size() > 1) {
            while (pQueue.size() > 1 && pQueue.peek()[1] <= x) pQueue.poll();
            while (next < length && x == buildings[next][0]) pQueue.offer(buildings[next++]);
            if (!pQueue.isEmpty()) {
                if (result.size() == 0 || pQueue.peek()[2] != result.get(result.size() - 1).get(1))
                    result.add(Arrays.asList(x, pQueue.peek()[2]));
                x = Math.min(pQueue.peek()[1], next >= length ? Integer.MAX_VALUE : buildings[next][0]);
            }
        }

        return result;
    }

}
