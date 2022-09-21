package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 2, 7, 11, 15 };
        int target1 = 9;
        int[] nums2 = new int[] { 3, 2, 4 };
        int target2 = 6;
        int[] nums3 = new int[] { 3, 3 };
        int target3 = 6;

        System.out.println("twoSum test cases,");
        System.out.println("twoSum testCase1 -> " + Arrays.toString(twoSum(nums1, target1)));
        System.out.println("twoSum testCase2 -> " + Arrays.toString(twoSum(nums2, target2)));
        System.out.println("twoSum testCase3 -> " + Arrays.toString(twoSum(nums3, target3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int expectedNum = target - nums[i];

            if (map.containsKey(expectedNum)) {
                ans[0] = map.get(expectedNum);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }
}
