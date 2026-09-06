class Solution {
    public int longestSubarray(int[] nums) {

        int count =0;
        int left =0;
        int right =0;
        int countZero =0;

        for(right =0;right<nums.length;right++){
            if(nums[right]==0){
                countZero++;

            }

            while(countZero>1){
                if(nums[left]==0){
                    countZero--;
                }
                left++;
                
            }

            count= Math.max(count,right-left);
        }
        return count;
        
    }
}


/**
 * Variable-Size Sliding Window Algorithm for Longest Subarray of 1's After Deleting One Element:
 * 
 * 1. Expand the Window:
 *    - Iterate with the 'right' pointer across the array.
 *    - If we encounter a 0, increment 'countZero'.
 * 
 * 2. Shrink the Window:
 *    - If 'countZero' exceeds 1, the window becomes invalid because we can only delete one element.
 *    - Move the 'left' pointer forward and decrement 'countZero' if a 0 leaves the window.
 * 
 * 3. Track Maximum Length:
 *    - Update 'count' with the current window size (right - left) at each step.
 *    - Note: We use 'right - left' instead of '+ 1' because the problem requires deleting one element.
 */