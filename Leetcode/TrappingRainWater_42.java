public class TrappingRainWater_42 {

    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int result = 0;
        int left = 0, val = height[0];
        byte hasConvex = -1;
        for (int i = 1; i < height.length; ++i) {
            if (val <= height[i]) {
                for (int j = left + 1; j < i; ++j) {
                    result += val - height[j];
                }
                left = i;
                val = height[i];
                hasConvex = -1;
            }
            if (height[i] < height[i - 1] && hasConvex != 1) hasConvex = 0;
            else if (height[i - 1] < height[i] && hasConvex == 0) hasConvex = 1;
        }

        if (hasConvex != 1) { return result; }
        int right = height.length - 1;
        val = height[right];
        for (int i = right - 1; i >= left; --i) {
            if (val <= height[i]) {
                for (int j = right - 1; j > i; --j) {
                    result += val - height[j];
                }
                right = i;
                val = height[i];
            }
        }

        return result;
    }

}
