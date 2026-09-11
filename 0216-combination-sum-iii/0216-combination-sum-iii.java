class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> helper = new ArrayList<>();
        backTrack(helper, new ArrayList<>(),k,n,1);


        return helper;


        
    }


    private void backTrack(List<List<Integer>> result, List<Integer> templist, int k, int remain, int start){

        if(templist.size()==k && remain ==0){
            result.add(new ArrayList<>(templist));
            return;

        }


        if(templist.size()>k || remain<0){
            return;
        }


        for(int i=start;i<=9;i++){
            templist.add(i);
            backTrack(result,templist,k,remain-i,i+1);

            templist.remove(templist.size()-1);
            
            
                    }





    }
}


/**
 * Approach for Combination Sum III (Backtracking / DFS):
 * 
 * 1. Number Pool & Order Constraints:
 *    - The available numbers are strictly restricted from 1 to 9, and each can be used at most once.
 *    - A `start` pointer is used in the loop to ensure numbers are picked in ascending order, 
 *      preventing duplicate combinations and element reuse.
 * 
 * 2. Recursive Backtracking Function:
 *    - Manages a temporary combination path (`tempList`), the target quantity of numbers (`k`), 
 *      the remaining target sum (`remain`), and the current `start` index.
 * 
 * 3. Base Cases & Pruning (Early Exits):
 *    - Success: If `tempList.size() == k` and `remain == 0`, a valid combination is found. 
 *      Save a copy of the path to the result list and return.
 *    - Pruning: If `tempList.size() > k` or `remain < 0`, the path has exceeded constraints 
 *      or overshot the target sum, so stop exploring this branch immediately.
 * 
 * 4. Choose, Explore, Un-choose (The Backtrack Step):
 *    - Loop through numbers from `start` to `9`:
 *        a. Choose: Add the current number `i` to the temporary path.
 *        b. Explore: Recursively call the function with the updated remaining sum (`remain - i`) 
 *           and the next available start index (`i + 1`).
 *        c. Un-choose: Remove the last element from the temporary path to clean up 
 *           before trying the next option.
 */