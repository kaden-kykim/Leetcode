public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int numNeg = 0, negFirst = -1, negLast = -1, startIndex = 0;
        int mul = 0, mulFirst = 1, mulLast = 1, max = 0;
        for (int i = 0; i <= length; ++i) {
            if (i == length || nums[i] == 0) {
                if (numNeg % 2 == 0) max = Math.max(max, mul);
                else {
                    if (numNeg == 1) {
                        if (i - startIndex > 1) max = Math.max(Math.max(max, mulFirst), mulLast);
                    } else {
                        max = Math.max(Math.max(max, mul / (mulFirst * -nums[negFirst])), mul / (mulLast * -nums[negLast]));
                    }
                }
                mul = 0; mulFirst = 1; mulLast = 1;
                numNeg = 0; negFirst = -1; negLast = -1; startIndex = i + 1;
            } else if (nums[i] < 0) {
                ++numNeg;
                if (negFirst == -1) { negFirst = i; mulFirst = (mul == 0) ? 1 : mul; }
                else { negLast = i; mulLast = 1; }
                mul = (mul == 0) ? -nums[i] : mul * -nums[i];
            } else {
                if (negFirst != -1) mulLast *= nums[i];
                mul = (mul == 0) ? nums[i] : mul * nums[i];
            }
        }
        return max;
    }

    public int maxProductOpt(int[] nums) {
        int maxProduct = Integer.MIN_VALUE, product = 1;
        for (int num : nums) {
            product *= num;
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) product = 1;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) product = 1;
        }
        return maxProduct;
    }

}
