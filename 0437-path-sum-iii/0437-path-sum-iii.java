/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        // Base case: a path starting from root equal to targetSum
        prefixSumMap.put(0L, 1); 
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> map) {
        if (node == null) return 0;

        currentSum += node.val;
        // Count paths ending at the current node
        int count = map.getOrDefault(currentSum - targetSum, 0);

        // Add current prefix sum to map
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        // Recurse down left and right branches
        count += dfs(node.left, currentSum, targetSum, map);
        count += dfs(node.right, currentSum, targetSum, map);

        // Backtrack so paths in other subtrees aren't affected
        map.put(currentSum, map.get(currentSum) - 1);

        return count;
    }
}