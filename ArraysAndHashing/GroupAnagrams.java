package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr1 = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        String[] arr2 = new String[] { "" };
        String[] arr3 = new String[] { "a" };

        System.out.println("groupAnagrams test cases,");
        System.out.println("groupAnagrams testCase1 -> " + groupAnagrams(arr1));
        System.out.println("groupAnagrams testCase2 -> " + groupAnagrams(arr2));
        System.out.println("groupAnagrams testCase3 -> " + groupAnagrams(arr3));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> stringAnagramsMap = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.parallelSort(arr);
            String key = String.valueOf(arr); // eg: "aet" for ["eat","tea","ate"]

            if (!stringAnagramsMap.containsKey(key))
                stringAnagramsMap.put(key, new ArrayList<>());

            stringAnagramsMap.get(key).add(s);
        }

        List<List<String>> resultList = new ArrayList<>();

        for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
            resultList.add(stringAnagrams.getValue());
        }
        return resultList;

    }
}
