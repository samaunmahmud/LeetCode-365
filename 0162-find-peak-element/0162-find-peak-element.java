class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Compare mid element with its right neighbor
            if (nums[mid] < nums[mid + 1]) {
                // Peak must lie on the right half
                low = mid + 1;
            } else {
                // Peak lies on the left half (including mid)
                high = mid;
            }
        }
        
        // low and high converge to a peak index
        return low;
    }
}