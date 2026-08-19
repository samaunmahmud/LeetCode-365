class Solution {
    public String reverseWords(String s) {

        
        var helper = s.split("\\s+");

        var build = new StringBuilder();

        for(int i=helper.length-1;i>=0;i--){
            
            build.append(helper[i]).append(" ");
        }

        



        

        return build.toString().trim();

        
    }
}