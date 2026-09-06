class Solution {
    public int singleNumber(int[] nums) {

        int single =0;

        for(int i: nums){
            single = single^i;
        }

        return single;
        
    }
}
/**
     * Explanation of how the XOR operator (^) works:
     * - Self-Cancellation (x ^ x = 0): Any number XORed with itself becomes 0.
     * - Identity (x ^ 0 = x): Any number XORed with 0 stays itself.
     * - Cancellation Effect: Because duplicate numbers pair up and cancel out to 0, 
     *   only the unique single number remains at the end.
     */


/**

class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        Arrays.sort(nums);
      
        
        for(int i=1;i<nums.length;i++){
            int k = nums[i];
            if(k!= nums[i-1]){
                return nums[i-1];
                
            }
            i=i+1;

        }

        return nums[nums.length-1];
        
    }
} */