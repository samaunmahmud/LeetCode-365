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