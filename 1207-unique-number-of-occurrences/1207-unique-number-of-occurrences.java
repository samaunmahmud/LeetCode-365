import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies of each number
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Add all frequencies to a Set
        Set<Integer> uniqueCounts = new HashSet<>(map.values());

        // Step 3: If uniqueCounts size matches map size, all counts are unique
        return map.size() == uniqueCounts.size();
    }
}