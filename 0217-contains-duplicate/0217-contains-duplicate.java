class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> container = new HashSet<>();

        for(int a: nums){
            if(container.contains(a)){
                return true;
            }else{
                container.add(a);
            }
        }

        return false;
        
    }
}