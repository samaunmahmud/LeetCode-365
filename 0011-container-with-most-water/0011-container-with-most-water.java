class Solution {
    public int maxArea(int[] height) {
        int i=0;

        int j = height.length-1;



        int max =0;
        int volume=0;


        while(i<j){
            if(height[i]<height[j]){
                volume = height[i]*(j-i);
                i++;

            }else{
                volume = height[j]*(j-i);
                j--;
            }

            if(volume > max){
                max = volume;
            }
        }


        return max;
        
    }
}