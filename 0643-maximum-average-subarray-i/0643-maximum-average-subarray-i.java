



class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Step 1: Compute sum of the first window of size k
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxSum = currentSum;

        // Step 2: Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k]; // Add incoming, subtract outgoing
            maxSum = Math.max(maxSum, currentSum);
        }

        // Step 3: Divide maximum sum by k to get max average
        return maxSum / k;
    }
}








// class Solution {
//     public double findMaxAverage(int[] nums, int k) {

//         double cal =0;
//         double max =-1;

//         for(int i=0;i<nums.length-k+1;i++){
//             cal=0;
//             for(int j=i;j<k+i;j++){
//                 cal=cal+nums[j];


//             }
//             if(cal>max){
//                 max = cal;
//             }
//         }


//         return max/k;
        
//     }
// }