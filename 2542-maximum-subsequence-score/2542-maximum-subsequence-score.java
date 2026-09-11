class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;


        int[][] pairs = new int[n][2];

        for(int i=0;i<n;i++){
            pairs[i][0]=nums2[i];
            pairs[i][1] =nums1[i];
        }

        Arrays.sort(pairs, (a,b)-> b[0]-a[0]);



        PriorityQueue<Integer> minHeap = new PriorityQueue<>();



        long currentSum = 0;
        long maxSum =0;



        for(int i=0;i<n;i++){
            int num2 = pairs[i][0];
            int num1 = pairs[i][1];


            minHeap.offer(num1);
            currentSum +=num1;

            if(minHeap.size()>k){
                currentSum -= minHeap.poll();
            }

            if(minHeap.size()==k){
                long currentScore = currentSum*num2;
                maxSum =Math.max(currentScore, maxSum);
            }
        }

        return maxSum;

        
    }
}