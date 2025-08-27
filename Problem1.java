import java.util.*;

//Time Complexity: O(nk) where k is the average length of the string since we are creating the hash for n strings with k length each
//Space Complexity: O(n) worse case where each word will not be an anagram and we will be storing n entries in the hashmap
//Did this code successfully run on Leetcode : Yes

/**
 * Anagrams have same letters in different order. So we need a hash function which will return the same hash value for strings that have the same letters.
 * Choosing prime product for that reason where the product will be same for the strings which have the same characters
 */
class Problem1 {
    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    static List<List<String>> getAnagrams(String[] strs) {
        final HashMap<Integer, List<String>> answer = new HashMap<>();
        for (String str : strs) {
            int hash = hash(str);
            if (!answer.containsKey(hash))
                answer.put(hash, new ArrayList<>());
            answer.get(hash).add(str);
        }

        return new ArrayList<>(answer.values());
    }

    private static int hash(String str) {
        int hash = 1;
        for (char c : str.toCharArray()) {
            hash *= primes[c - 'a'];
        }

        return hash;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"tea", "eat", "ate", "tan", "atn", "meat", "team", "ball"};
        System.out.println(getAnagrams(strs));
    }
}