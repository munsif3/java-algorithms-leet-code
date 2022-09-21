package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] testCase1 = new int[] { 1, 1, 1, 2, 2, 3 };
        int k1 = 2;
        int[] testCase2 = new int[] { 1 };
        int k2 = 1;

        System.out.println("topKFrequent test cases,");
        System.out.println("testCase1 -> " + Arrays.toString(topKFrequent(testCase1, k1)));
        System.out.println("testCase2 -> " + Arrays.toString(topKFrequent(testCase2, k2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int[] res = new int[k];

        for (int el : nums) {
            int elFromMap = countMap.getOrDefault(el, 0);
            if (!countMap.containsKey(el)) {
                countMap.put(el, elFromMap);
            }
            countMap.put(el, 1 + elFromMap);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            queue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }
}
