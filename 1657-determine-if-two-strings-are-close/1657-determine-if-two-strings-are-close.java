

import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        // Count frequencies using HashMaps
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : word1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (char c : word2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);

        // Condition 2: Check if both strings have the exact same unique set of characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // Condition 3: Check if frequency distributions match
        List<Integer> freq1 = new ArrayList<>(map1.values());
        List<Integer> freq2 = new ArrayList<>(map2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }
}













// import java.util.Arrays;

// class Solution {
//     public boolean closeStrings(String word1, String word2) {
//         // Condition 1: Must be the same length
//         if (word1.length() != word2.length()) {
//             return false;
//         }

//         // Count frequency of each character (a-z)
//         int[] freq1 = new int[26];
//         int[] freq2 = new int[26];

//         for (char c : word1.toCharArray()) {
//             freq1[c - 'a']++;
//         }

//         for (char c : word2.toCharArray()) {
//             freq2[c - 'a']++;
//         }

//         // Condition 2: Must contain the exact same unique characters
//         for (int i = 0; i < 26; i++) {
//             if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[i] == 0)) {
//                 return false;
//             }
//         }

//         // Condition 3: Sorted frequency profiles must match
//         Arrays.sort(freq1);
//         Arrays.sort(freq2);

//         return Arrays.equals(freq1, freq2);
//     }
// }