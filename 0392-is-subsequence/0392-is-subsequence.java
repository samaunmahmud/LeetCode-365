class Solution {
    public boolean isSubsequence(String s, String t) {

        int i=0;
        boolean check = true;
        int j=0;

        while(i<t.length()&& j<s.length()){

            if(s.charAt(j)==t.charAt(i)){
                j++;
                i++;
                check = true;
                
            }else{
                i++;
            }

        }

        if(j!=s.length()){
            return false;
        }

        return true;
        
    }
}