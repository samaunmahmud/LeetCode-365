class Solution {
    /**
     * Explanation of the Minimum Flips Solution:
     * 
     * 1. BIT-BY-BIT PROCESSING:
     *    We use a while loop that runs until all numbers (a, b, c) are reduced to 0.
     *    In each iteration, we check the rightmost bit of each number using '& 1'.
     * 
     * 2. SCENARIO A (Target bitC is 0):
     *    To make (a OR b) result in 0, both bitA and bitB must be 0. 
     *    If either is 1, it must be flipped. We add (bitA + bitB) to our flip count.
     * 
     * 3. SCENARIO B (Target bitC is 1):
     *    To make (a OR b) result in 1, at least one of bitA or bitB must be 1. 
     *    If both are 0, we need exactly 1 flip to make one of them 1.
     * 
     * 4. SHIFTING:
     *    We use '>>= 1' to drop the current bit and move on to the next bit position.
     */
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        // Loop until all numbers have been checked (all bits are 0)
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            
            if (bitC == 0) {
                // If c is 0, both a and b must be 0. 
                // Any 1s in a or b must be flipped.
                flips += (bitA + bitB);
            } else {
                // If c is 1, at least one of a or b must be 1.
                // If both are currently 0, we need 1 flip.
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }
            
            // Shift right to move to the next bit position
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return flips;
    }
}