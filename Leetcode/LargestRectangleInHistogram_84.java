import java.util.Arrays;

public class LargestRectangleInHistogram_84 {

    /** Runtime: 2 ~ 5 ms */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int length = heights.length;
        int[] possibleLeft = new int[length];
        int[] possibleRight = new int[length];

        int possible;
        possibleLeft[0] = 0;
        for (int i = 1; i < length; ++i) {
            possible = i;
            while (--possible >= 0 && heights[possible] >= heights[i])
                possible = possibleLeft[possible];
            possibleLeft[i] = possible + 1;
        }

        possibleRight[length - 1] = length - 1;
        for (int i = length - 2; i >= 0; --i) {
            possible = i;
            while (++possible < length && heights[possible] >= heights[i])
                possible = possibleRight[possible];
            possibleRight[i] = possible - 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            max = Math.max(max, heights[i] * (possibleRight[i] - possibleLeft[i] + 1));
        }
        return max;
    }

    /** Runtime: 1300 ~ 2000 ms */
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int length = heights.length;
        int[] dpMin = Arrays.copyOf(heights, heights.length);
        int max = Integer.MIN_VALUE;
        for (int m : dpMin) max = Math.max(max, m);
        for (int i = 2; i <= length; ++i) {
            for (int j = 0; j <= length - i; ++j) {
                dpMin[j] = Math.min(dpMin[j], dpMin[j + 1]);
                max = Math.max(max, dpMin[j] * i);
            }
        }
        return max;
    }

}
