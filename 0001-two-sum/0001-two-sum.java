class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> helper = new HashMap<>();

        int[] result = new int[2];


        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];

            if(helper.containsKey(diff)){
                result[0]=helper.get(diff);
                result[1]=i;
            }

            helper.put(nums[i],i);
        }

        return result;
        
    }
}