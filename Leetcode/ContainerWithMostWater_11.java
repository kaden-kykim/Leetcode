public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    public int maxAreaSolution(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int lh = height[l], rh = height[r];
            if (lh < rh) max = Math.max(max, (r - l++) * lh);
            else max = Math.max(max, (r-- - l) * rh);
        }
        return max;
    }

//    public static void main(String[] args) {
//        System.out.println("55, " + new ContainerWithMostWater_11().maxArea(new int[]{5, 2, 12, 1, 5, 3, 4, 11, 9, 4})); // 55
//        System.out.println("49, " + new ContainerWithMostWater_11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
//        System.out.println("4, " + new ContainerWithMostWater_11().maxArea(new int[]{1, 2, 4, 3})); // 4
//        System.out.println("36, " + new ContainerWithMostWater_11().maxArea(new int[]{4, 2, 4, 2, 6, 12, 5, 4, 2, 4})); // 36
//        System.out.println("72, " + new ContainerWithMostWater_11().maxArea(new int[]{9, 6, 14, 11, 2, 2, 4, 9, 3, 8})); // 72
//        System.out.println("2, " + new ContainerWithMostWater_11().maxArea(new int[]{1, 2, 1})); // 2
//        System.out.println("96, " + new ContainerWithMostWater_11().maxArea(new int[]{10, 14, 10, 4, 10, 2, 6, 1, 6, 12})); // 96
//        System.out.println("17, " + new ContainerWithMostWater_11().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6})); // 17
//        System.out.println("36, " + new ContainerWithMostWater_11().maxArea(new int[]{2, 3, 10, 5, 7, 8, 9})); // 36
//        System.out.println("14608, " + new ContainerWithMostWater_11().maxArea(new int[]{75, 21, 3, 152, 13, 107, 163, 166, 32, 160, 41, 131, 7, 67, 56, 5, 153, 176, 29, 139, 61, 149, 176, 142, 64, 75, 170, 156, 73, 48, 148, 101, 70, 103, 53, 83, 11, 168, 1, 195, 81, 43, 126, 88, 62, 134, 45, 167, 63, 26, 107, 124, 128, 83, 67, 192, 158, 189, 149, 184, 37, 49, 85, 107, 152, 90, 143, 115, 58, 144, 62, 139, 139, 189, 180, 153, 75, 177, 121, 138, 4, 28, 15, 132, 63, 82, 124, 174, 23, 25, 110, 60, 74, 147, 120, 179, 37, 63, 94, 47}));
//        System.out.println("15423, " + new ContainerWithMostWater_11().maxArea(new int[]{159, 157, 139, 51, 98, 71, 4, 125, 48, 125, 64, 4, 105, 79, 136, 169, 113, 13, 95, 88, 190, 5, 148, 17, 152, 20, 196, 141, 35, 42, 188, 147, 199, 127, 198, 49, 150, 154, 175, 199, 80, 191, 3, 137, 22, 92, 58, 87, 57, 153, 175, 199, 110, 75, 16, 62, 96, 12, 3, 83, 55, 144, 30, 6, 23, 28, 56, 174, 183, 183, 173, 15, 126, 128, 104, 148, 172, 163, 35, 181, 68, 162, 181, 179, 37, 197, 193, 85, 10, 197, 169, 17, 141, 199, 175, 164, 180, 183, 90, 115}));
//        System.out.println("15936, " + new ContainerWithMostWater_11().maxArea(new int[]{177, 112, 74, 197, 90, 16, 4, 61, 103, 133, 198, 4, 121, 143, 55, 138, 47, 167, 165, 159, 93, 85, 53, 118, 127, 171, 137, 65, 135, 45, 151, 64, 109, 25, 61, 152, 194, 65, 165, 97, 199, 163, 53, 72, 58, 108, 10, 105, 27, 127, 64, 120, 164, 70, 190, 91, 41, 127, 109, 176, 172, 12, 193, 34, 38, 54, 138, 184, 120, 103, 33, 71, 66, 86, 143, 125, 146, 105, 182, 173, 184, 199, 46, 148, 69, 36, 192, 110, 116, 53, 38, 40, 65, 31, 74, 103, 86, 12, 39, 158}));
//    }
}
