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


/**
 * How the Sliding Window Algorithm Works for maxVowels:
 * 
 * 1. Preprocessing:
 *    - We convert the string to a lowercase character array ('holder') 
 *      to avoid case-sensitivity issues and extra overhead during loops.
 * 
 * 2. First Window (Initialization):
 *    - We loop from index 0 to k - 1 to count the vowels in the 
 *      initial window of size 'k', storing it in 'currentVowels' 
 *      and setting our initial 'max'.
 * 
 * 3. Sliding Phase:
 *    - As the loop moves 'i' from 'k' to the end of the array, the window shifts right by 1 index.
 *    - We remove the old character: If the character leaving on the left (index i - k) was a vowel, we decrement 'currentVowels'.
 *    - We add the new character: If the new character entering on the right (index i) is a vowel, we increment 'currentVowels'.
 *    - We update 'max': We compare the updated 'currentVowels' with 'max' using Math.max() to keep the highest count.
 */