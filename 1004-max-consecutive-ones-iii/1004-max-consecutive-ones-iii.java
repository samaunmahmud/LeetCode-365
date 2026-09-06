class Solution {
    public int longestOnes(int[] nums, int k) {

        int countZero =0;

        int count =0;

        int left = 0;
        int right = 0;


        for(right = 0;right<nums.length;right++){
            if(nums[right]==0){
                countZero++;
            }


            while(countZero>k){
                if(nums[left]==0){
                    countZero--;
                }
                left++;
            }

            count = Math.max(count,right-left+1);
            
        }
        return count;
        
    }

    
}


/**
 * Variable-Size Sliding Window Algorithm for Max Consecutive Ones III:
 * 
 * 1. Expand the Window:
 *    - Iterate with the 'right' pointer across the array. 
 *    - If we encounter a 0, increment our 'zeroCount' (representing a used flip).
 * 
 * 2. Shrink the Window:
 *    - If 'zeroCount' exceeds 'k', the window becomes invalid. 
 *    - Move the 'left' pointer forward to shrink the window until 'zeroCount' drops back to 'k'.
 *    - If the element leaving at the 'left' pointer is a 0, decrement 'zeroCount'.
 * 
 * 3. Track Maximum Length:
 *    - At each valid step, update 'maxLength' with the current window size (right - left + 1).
 */