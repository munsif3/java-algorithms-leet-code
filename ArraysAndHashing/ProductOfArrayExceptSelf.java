package ArraysAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] testCase1 = new int[] { 1, 2, 3, 4 };
        int[] testCase2 = new int[] { -1, 1, 0, -3, 3 };

        System.out.println("productExceptSelf test cases,");
        System.out.println("testCase1 -> " + Arrays.toString(productExceptSelf(testCase1)));
        System.out.println("testCase1 -> " + Arrays.toString(productExceptSelf(testCase2)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int postfix = 1;
        int numsLength = nums.length;
        int[] result = new int[numsLength];
        Arrays.fill(result, 1);

        for (int i = 0; i < numsLength; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }

        return result;
    }
}
