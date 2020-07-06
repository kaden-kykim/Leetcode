import java.util.ArrayList;
import java.util.List;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        List<int[]> result = merge(0, intervals.length, intervals);
        return result.toArray(new int[result.size()][2]);
    }

    private List<int[]> merge(int start, int end, int[][] intervals) {
        int length = end - start;
        List<int[]> result = new ArrayList<>();
        if (length == 0) return result;
        if (length == 1) {
            result.add(intervals[start]);
            return result;
        }

        int half = start + length / 2;
        List<int[]> left = merge(start, half, intervals);
        List<int[]> right = merge(half, end, intervals);
        while (left.size() != 0 && right.size() != 0) {
            int[] minElem = (left.get(0)[0] < right.get(0)[0]) ? left.remove(0) : right.remove(0);
            if (result.size() == 0) result.add(minElem);
            else mergeElement(minElem, result);
        }
        List<int[]> remain = (left.size() != 0) ? left : right;
        while (remain.size() != 0) mergeElement(remain.remove(0), result);

        return result;
    }

    private void mergeElement(int[] element, List<int[]> result) {
        int[] last = result.get(result.size() - 1);
        if (element[0] <= last[1]) last[1] = Math.max(element[1], last[1]);
        else result.add(element);
    }

}
