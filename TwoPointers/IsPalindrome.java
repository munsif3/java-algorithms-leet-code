package TwoPointers;

public class IsPalindrome {

    public static void main(String[] args) {
        String string1 = "A man, a plan, a canal: Panama";
        String string2 = "race a car";
        String string3 = " ";

        System.out.println("isPalindrome test cases,");
        System.out.println("isPalindrome testCase1 -> " + isPalindrome(string1));
        System.out.println("isPalindrome testCase2 -> " + isPalindrome(string2));
        System.out.println("isPalindrome testCase3 -> " + isPalindrome(string3));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            Character start = s.charAt(i);
            Character end = s.charAt(i);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
