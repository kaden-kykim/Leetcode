public class MedianOfTwoSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        boolean isOdd = (m + n) % 2 == 1;
        if (n < m) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            m = nums1.length; n = nums2.length;
        }
        int left = 0, right = m, halfLen = (m + n + 1) / 2;
        while (left <= right) {
            int i = (left + right) / 2, j = halfLen - i;
            if (i < right && nums1[i] < nums2[j - 1]) left = i + 1;
            else if (left < i && nums2[j] < nums1[i - 1]) right = i - 1;
            else {
                int maxLeft = i == 0 ? nums2[j - 1] : (j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]));
                if (isOdd) return maxLeft;
                int minRight = i == m ? nums2[j] : (j == n ? nums1[i] : Math.min(nums1[i], nums2[j]));
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }

}
