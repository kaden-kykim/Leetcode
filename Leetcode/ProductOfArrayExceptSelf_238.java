import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, 1);
        int mul = 1;
        for (int i = 0; i < length; ++i) { result[i] *= mul; mul *= nums[i]; }
        mul = 1;
        for (int i = length - 1; i >= 0; --i) { result[i] *= mul; mul *= nums[i]; }
        return result;
    }

    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int length = nums.length;
        int[] prefix = new int[length], postfix = new int[length];
        int mul = 1;
        for (int i = 0; i < length - 1; ++i) prefix[i] = mul *= nums[i];
        mul = 1;
        for (int i = length - 1; i >= 1; --i) postfix[i] = mul *= nums[i];
        int[] result = new int[length];
        result[0] = postfix[1]; result[length - 1] = prefix[length - 2];
        for (int i = 1; i < length - 1; ++i) result[i] = prefix[i - 1] * postfix[i + 1];
        return result;
    }

}
