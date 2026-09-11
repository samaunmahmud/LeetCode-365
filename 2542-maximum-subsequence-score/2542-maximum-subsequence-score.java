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



/**
 * Approach for Maximum Subsequence Score (Greedy + Min-Heap):
 * 
 * 1. Pair and Sort by nums2:
 *    - Combine nums1 and nums2 into pairs so their index associations aren't lost.
 *    - Sort the pairs in descending order based on nums2 values. This ensures that 
 *      as we iterate, the current nums2 value is always the minimum of our chosen group.
 * 
 * 2. Min-Heap for nums1 Sum:
 *    - Use a Min-Heap (PriorityQueue) to track the smallest nums1 values dynamically.
 *    - Maintain a running total sum of the current group of elements.
 * 
 * 3. Size Maintenance (Keeping Top k):
 *    - For each pair, add its nums1 value to the sum and the min-heap.
 *    - If the heap size exceeds k, remove (poll) the smallest nums1 value from the sum 
 *      to ensure we always keep the largest possible subset sum.
 * 
 * 4. Score Tracking:
 *    - Whenever the heap size hits exactly k, calculate the current score (currentSum * currentNum2) 
 *      and update your global maximum score tracker.
 */