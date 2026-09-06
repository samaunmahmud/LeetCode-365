class Solution {
    public int maxVowels(String s, int k) {

        char[] holder = s.toLowerCase().toCharArray();

        int currentVowels =0;


        for(int i =0;i<k;i++){
            if(isVowels(holder[i])){
                currentVowels++;
            }
        }

        int max = currentVowels;


        for(int i=k;i<holder.length;i++){
            if(isVowels(holder[i-k])){
                currentVowels--;
            }


            if(isVowels(holder[i])){
                currentVowels++;
            }

            max = Math.max(max,currentVowels);
        }

        return max;



        
    }


    private boolean isVowels(char c){
        if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
            return true;
        }

        return false;
    }
}