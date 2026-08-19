class Solution {
    public int[] productExceptSelf(int[] nums) {

        int helper = MultipleHelper(nums);

        boolean check = checkZero(nums);



        for(int i=0;i<nums.length;i++){
            if(check == true && nums[i]!=0){
                nums[i]=0;

            }else if(nums[i]==0){
                nums[i]=helper;

            }else{
                nums[i]=helper/nums[i];
            }
        }

        return nums;




        
        
    }


    private int MultipleHelper(int[] nums){
        int helper =1;
        int count =0;

        boolean flag;

        for(int i=0;i<nums.length;i++){

            if(nums[i]== 0){
                count++;
                continue;
            }
            helper = helper*nums[i];

        }

        if(count>1){
            return 0;
        }
        

        return helper;

    }

    private boolean checkZero(int[] nums){


        for(int i=0;i<nums.length;i++){

            if(nums[i]== 0){
                return true;
            }
            

        }

        return false;


    }
}