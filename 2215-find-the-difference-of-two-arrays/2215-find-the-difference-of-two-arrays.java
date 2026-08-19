import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Step 1: Add elements into Sets to handle uniqueness
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Step 2: Build result lists for unique elements
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                r1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                r2.add(num);
            }
        }

        // Step 3: Combine into a 2D List
        List<List<Integer>> result = new ArrayList<>();
        result.add(r1);
        result.add(r2);

        return result;
    }
}