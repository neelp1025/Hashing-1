import java.util.*;

//Time Complexity: O(nk) where n is the length of the words in the string since we have to iterate through each string to create the hash for each string with average k length
//Space Complexity: O(n) since the map will have the n entries max
//Did this code successfully run on Leetcode : Yes

/**
 * Created a hash function which will generate unique hash based on the characters in the string and their position in the string.
 * Matching the pattern character to its mapped word and matching the word to its mapped character to make sure that 'a' -> "dog" <- 'b' scenarios return false
 */
class Problem3 {

    static boolean isPatternMatching(String pattern, String str) {
        int patternLength = pattern.length();
        String[] words = str.split(" ");
        if (patternLength != words.length)
            return false;

        Map<Character, Integer> wordhashByPattern = new HashMap<>();
        Map<Integer, Character> patternByWordHash = new HashMap<>();

        for (int i = 0; i < patternLength; i++) {
            char c = pattern.charAt(i);
            int wordHash = hash(words[i]);
            if (wordhashByPattern.containsKey(c)) {
                if (!wordhashByPattern.get(c).equals(wordHash))
                    return false;
            }
            else {
                wordhashByPattern.put(c,wordHash);
            }

            if (patternByWordHash.containsKey(wordHash)) {
                if (!patternByWordHash.get(wordHash).equals(c))
                    return false;
            }
            else {
                patternByWordHash.put(wordHash,c);
            }
        }

        return true;
    }

    static int hash(String word) {
        int hash = 0;
        for (int i = 0; i < word.length(); i ++) {
            hash = 31 * hash + word.charAt(i);
        }

        return hash;
    }


    public static void main(String[] args) {
        System.out.println(isPatternMatching("abba", "dog cat cat dog")); //true
        System.out.println(isPatternMatching("abba", "dog cat act dog")); //false- making sure hash function is correct for anagram
        System.out.println(isPatternMatching("abba", "dog cat cat fish")); //false
        System.out.println(isPatternMatching("aaaa", "dog cat cat dog")); //false
        System.out.println(isPatternMatching("abba", "dog dog dog dog")); //false
    }
}