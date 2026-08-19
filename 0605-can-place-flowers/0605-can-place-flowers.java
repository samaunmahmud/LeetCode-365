class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            int current = i;
            int prev = i - 1;
            int next = i + 1;

            // 1. Current spot must be empty
            if (flowerbed[current] == 0) {
                
                // 2. Left spot must be out of bounds OR empty
                boolean prevIsZero = (prev < 0 || flowerbed[prev] == 0);
                
                // 3. Right spot must be out of bounds OR empty
                boolean nextIsZero = (next >= flowerbed.length || flowerbed[next] == 0);

                // If all 3 conditions hold, plant a flower
                if (prevIsZero && nextIsZero) {
                    flowerbed[current] = 1; // Mark plot as filled
                    count++;
                }
            }
        }

        return count >= n;
    }
}