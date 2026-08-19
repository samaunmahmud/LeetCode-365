class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> check = new ArrayList<>();
        boolean confirm =false;
        int maxCandies =0;


        for(int candy : candies){
            if(maxCandies<candy){
                maxCandies = candy;
            }
        }



        for(int candy : candies){
            check.add(candy+extraCandies >= maxCandies);
        }

        
        return check;
        
    }
}