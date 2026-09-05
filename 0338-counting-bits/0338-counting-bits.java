class Solution {
    /**
     * Explanation:
     * This method uses Dynamic Programming in O(n) time to count 1s in binary:
     * - ans[i >> 1]: Looks up the bit count of the number divided by 2 (shifting bits right).
     * - (i & 1): Checks the last bit to add 1 if the number is odd, or 0 if it is even.
     */
    public int[] countBits(int n) {
        // Create an array of size n + 1 to store counts from 0 to n
        int[] ans = new int[n + 1];
        
        // Base case: ans[0] is already 0 by default
        
        for (int i = 1; i <= n; i++) {
            // Number of 1s in i = 1s in (i / 2) + (1 if i is odd, else 0)
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}