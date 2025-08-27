import java.util.*;

//Time Complexity: O(n) where n is the length of the string assuming that both strings are same length since we have to iterate through each character
//Space Complexity: O(1) it will have 26 entries max
//Did this code successfully run on Leetcode : Yes

/**
 * String are isomorphic where each unique character from s is mapped to unique character from t. So, maintaining the mapping in both directions to check if each character is mapped uniquely in both directions.
 */
class Problem2 {

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length();i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar)
                    return false;
            }
            else
                sMap.put(sChar, tChar);

            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sChar)
                    return false;
            }
            else
                tMap.put(tChar, sChar);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("bar", "foo"));
    }
}