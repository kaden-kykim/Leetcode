public class MergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; --i) {
            if (m == 0) nums1[i] = nums2[--n];
            else if (n == 0) nums1[i] = nums1[--m];
            else nums1[i] = (nums1[m - 1] < nums2[n - 1]) ? nums2[--n] : nums1[--m];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] sortedArr = new int[nums1.length];
        int i = 0, i1 = 0, i2 = 0;
        while (i1 != m && i2 != n)
            sortedArr[i++] = (nums1[i1] < nums2[i2]) ? nums1[i1++] : nums2[i2++];
        int[] remain = (i1 != m) ? nums1 : nums2;
        int remI = (i1 != m) ? i1 : i2;
        for (; i < sortedArr.length; ++i, ++remI)
            sortedArr[i] = remain[remI];
        for (i = 0; i < nums1.length; ++i) nums1[i] = sortedArr[i];
    }

}
