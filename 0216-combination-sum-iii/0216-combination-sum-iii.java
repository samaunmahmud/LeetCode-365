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