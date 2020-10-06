import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resultList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            int num1 = nums1[i], num2 = nums2[j];
            if (num1 == num2) {
                resultList.add(num1);
                ++i; ++j;
            } else if (num1 < num2) ++i;
            else ++j;
        }
        int[] result = new int[resultList.size()];
        for (int n = 0; n < resultList.size(); ++n) result[n] = resultList.get(n);
        return result;
    }

}
