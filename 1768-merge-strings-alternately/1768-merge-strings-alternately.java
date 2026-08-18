class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result= new StringBuilder();
        int x=0,y=0;
        boolean check =true;

        while(x<word1.length() || y<word2.length()){
            if(check && x<word1.length()){
                result.append(word1.charAt(x++));
                check=false;
                
            }

            if(x>=word1.length()){
                check = false;
            }
            
            if(!check && y<word2.length()){
                result.append(word2.charAt(y++));
                check=true;
            }

            if(y>=word2.length()){
                check=true;
            }
        }

        return result.toString();
        
    }
}