package ArraysAndHashing;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";

        System.out.println("isAnagram test cases,");
        System.out.println("isAnagram testCase1 -> " + isAnagram(s1, t1));
        System.out.println("isAnagram testCase2 -> " + isAnagram(s2, t2));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sSort = s.toCharArray();
        Arrays.sort(sSort);

        char[] tSort = t.toCharArray();
        Arrays.sort(tSort);

        return String.valueOf(sSort).equals(String.valueOf(tSort));

        // Map<Character, Integer> countS = new HashMap<>();
        // Map<Character, Integer> countT = new HashMap<>();

        // for (int i = 0 ; i < s.length(); i++) {
        // // System.out.println("s.charAt(i) -> " + s.charAt(i));
        // countS.put(s.charAt(i), 1 + countS.getOrDefault(s.charAt(i), 0));
        // countT.put(t.charAt(i), 1 + countT.getOrDefault(t.charAt(i), 0));
        // }

        // boolean allMatch = true;

        // for (Map.Entry<Character,Integer> c : countS.entrySet()) {
        // if (!c.getValue().equals(countT.get(c.getKey()))) {
        // allMatch = false;
        // }
        // }

        // return allMatch;
    }
}