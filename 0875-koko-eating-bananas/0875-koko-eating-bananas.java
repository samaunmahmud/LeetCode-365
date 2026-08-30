class Solution {
    /*
     * PROBLEM STATEMENT (What it's asking):
     * Koko has 'n' piles of bananas and 'h' hours before guards return.
     * She eats at a speed of 'k' bananas per hour from a chosen pile.
     * Goal: Find the MINIMUM integer eating speed 'k' such that she 
     * finishes all the banana piles within 'h' hours.
     */
    public int minEatingSpeed(int[] piles, int h) {
        // The minimum possible eating speed (she must eat at least 1 banana/hour)
        int low = 1;
        
        // The maximum possible speed is the size of the largest pile.
        // Eating faster than the biggest pile doesn't save extra time.
        int high = 0;
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }
        
        int minSpeed = high; // Default fallback to max speed
        
        /* 
         * APPROACH: Binary Search on the Answer
         * Instead of checking every speed sequentially (O(N * max)), 
         * we binary search between 1 and max(piles), dropping time to O(N log M).
         */
        while (low <= high) {
            int mid = low + (high - low) / 2; // Guess a speed 'mid'
            
            // Check if Koko can finish all bananas at this guessed speed within 'h' hours
            if (canFinish(piles, h, mid)) {
                minSpeed = mid;    // Valid speed found! Save it as a potential answer.
                high = mid - 1;    // Try to find an even slower (smaller) speed.
            } else {
                low = mid + 1;     // Too slow! We need to increase our speed.
            }
        }
        
        return minSpeed;
    }
    
    /* 
     * HELPER FUNCTION: Validates if speed 'k' works within 'h' hours.
     */
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0; // Use long to prevent integer overflow
        
        for (int pile : piles) {
            /* 
             * CEILING DIVISION TRICK:
             * We need Math.ceil((double) pile / k), but decimals are slow/inaccurate.
             * Adding (k - 1) before integer division forces remainders to round up.
             * Example: pile = 7, k = 4 -> (7 + 4 - 1) / 4 = 10 / 4 = 2 hours.
             */
            totalHours += (pile + k - 1) / k;
        }
        
        // Returns true if total hours needed is less than or equal to guard limit 'h'
        return totalHours <= h;
    }
}