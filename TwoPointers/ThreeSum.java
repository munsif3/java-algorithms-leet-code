package TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = new int[] { -1, 0, 1, 2, -1, -4 };
        int[] nums2 = new int[] { 0, 1, 1 };
        int[] nums3 = new int[] { 0, 0, 0 };

        System.out.println("threeSum test cases,");
        System.out.println("threeSum testCase1 -> " + threeSum(nums1));
        System.out.println("threeSum testCase2 -> " + threeSum(nums2));
        System.out.println("threeSum testCase3 -> " + threeSum(nums3));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            // if it's the first element or the current value is not the same as the
            // previous value
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                // define the left and right pointers
                int left = i + 1;
                int right = nums.length - 1;

                // can't let both pointers pass each other
                while (left < right) {
                    // if the value of the left pointer and the right pointer sums up to the
                    // remainder of the amount subtracted from the current nums[i] value
                    if (nums[left] + nums[right] == target) {
                        // add the three numbers to the solutions list
                        ArrayList<Integer> miniSol = new ArrayList<>();
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        sol.add(miniSol);

                        // if the current left value and the next value are the same number then no point
                        // to checking against the right number; so increment the left pointer 
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // if the current right value and the next value are the same number then no point
                        // to checking against the left number; so decrement the right pointer 
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // update the pointers
                        left++;
                        right--;

                    // if the value of the left pointer and the right pointer sums up to be greater
                    // than the remainder of the amount subtracted from the current nums[i] value
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return sol;
    }
}
