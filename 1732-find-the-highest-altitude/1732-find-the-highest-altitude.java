class Solution {
    public int largestAltitude(int[] gain) {


        int currentAltitude = 0;
        int maxAltitude =0;
        int k =0;

        while(k < gain.length){

            currentAltitude = currentAltitude+gain[k];

            if(maxAltitude<currentAltitude){
                maxAltitude = currentAltitude;
            }
            k++;

        }


        return maxAltitude;
        


        
    }
}