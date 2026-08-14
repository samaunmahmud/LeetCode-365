import java.util.HashMap;


class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> assistant = new HashMap<>();
        int[] result = new int[2];
        
        

        for(int i =0;i<nums.length;i++){
            int check = target-nums[i];
            if(assistant.containsKey(check)){
            
            result[0]=assistant.get(check);
            result[1]= i;
            assistant.put(nums[i], i);
            
            return result;

            }
            assistant.put(nums[i], i);
        



                
            }

            return result;
        }
        
    }
