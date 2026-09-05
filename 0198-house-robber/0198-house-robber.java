class Solution {
    public int rob(int[] nums) {

        int length = nums.length;

        if(length == 0){
            return 0;
        }

        if(length ==1){
            return nums[0];
        }



        int prev2 =nums[0];
        int prev1 = Math.max(nums[0],nums[1]);


        for(int i=2;i< length;i++){
            int current = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = current;
        }        



        return prev1;
    }
}