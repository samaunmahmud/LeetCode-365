class Solution {
    /**
     * Explanation of the Domino and Tromino Tiling Solution (O(1) Space Complexity):
     * 
     * 1. BASE CASES:
     *    For n = 1, 2, and 3, the number of ways to tile a 2 x n board are fixed:
     *    - n = 1 -> 1 way (one vertical domino)
     *    - n = 2 -> 2 ways (two vertical dominos or two horizontal dominos)
     *    - n = 3 -> 5 ways
     *    We handle these upfront to avoid out-of-bounds or unnecessary loops.
     * 
     * 2. MODULO ARITHMETIC:
     *    Because the number of ways can grow extremely large for big values of n, 
     *    the problem requires us to return the answer modulo 1,000,000,007.
     * 
     * 3. STATE TRACKING VARIABLES (Optimizing space to O(1)):
     *    Instead of creating a bulky array to store every single past result, 
     *    we only need to track the last few steps to calculate the next one:
     *    - dp3: represents f(n-1) (starts at n=3 -> 5)
     *    - dp2: represents f(n-2) (starts at n=2 -> 2)
     *    - dp1: represents f(n-3) (starts at n=1 -> 1)
     *    - p2:  tracks the "partially filled" board state 
     * 
     * 4. THE LOOP (Building up from 4 to n):
     *    For every step 'i', we update:
     *    - currentP = (dp1 + p2) % MOD
     *    - currentDp = (dp3 + dp2 + 2 * currentP) % MOD
     *    - Shift variables forward for the next iteration.
     * 
     * 5. FINAL RETURN:
     *    Once the loop finishes at 'n', dp3 holds our final answer, cast to an int.
     */
    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        long MOD = 1_000_000_007;
        
        long dp3 = 5; // ways for n = 3
        long dp2 = 2; // ways for n = 2
        long dp1 = 1; // ways for n = 1
        
        long p2 = 1;  // partially filled state for n = 2
        
        long currentDp = 0;
        
        for (int i = 4; i <= n; i++) {
            long currentP = (dp1 + p2) % MOD;
            currentDp = (dp3 + dp2 + 2 * currentP) % MOD;
            
            // Shift variables forward
            dp1 = dp2;
            dp2 = dp3;
            dp3 = currentDp;
            p2 = currentP;
        }
        
        return (int) dp3;
    }
}