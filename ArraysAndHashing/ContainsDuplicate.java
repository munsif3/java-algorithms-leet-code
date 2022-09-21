package ArraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] testCase1 = new int[] { 1, 2, 3, 1 };
        int[] testCase2 = new int[] { 1, 2, 3, 4 };
        int[] testCase3 = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        System.out.println("containsDuplicate test cases,");
        System.out.println("testCase1 -> " + containsDuplicate(testCase1));
        System.out.println("testCase2 -> " + containsDuplicate(testCase2));
        System.out.println("testCase3 -> " + containsDuplicate(testCase3));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}