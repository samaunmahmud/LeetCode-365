import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Condition 1: Must be the same length
        if (word1.length() != word2.length()) {
            return false;
        }

        // Count frequency of each character (a-z)
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Condition 2: Must contain the exact same unique characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Condition 3: Sorted frequency profiles must match
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}