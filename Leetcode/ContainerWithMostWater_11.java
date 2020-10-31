public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int lh = height[l], rh = height[r];
            if (lh < rh) max = Math.max(max, (r - l++) * lh);
            else max = Math.max(max, (r-- - l) * rh);
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

}
