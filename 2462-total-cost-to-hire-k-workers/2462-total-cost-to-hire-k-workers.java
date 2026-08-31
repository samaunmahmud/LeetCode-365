class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        

        int n = costs.length;

        long totalCost =0;




        int i=0;
        int j=n-1;

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();




        for(int hired =0; hired<k;hired++){
            while(leftHeap.size()<candidates && i<=j){
                leftHeap.offer(costs[i++]);
            }


            while(rightHeap.size()< candidates && i<=j){
                rightHeap.offer(costs[j--]);
            }



            if(leftHeap.isEmpty()){
                totalCost+= rightHeap.poll();
            }else if(rightHeap.isEmpty()){
                totalCost+= leftHeap.poll();
            }else if(leftHeap.peek()<= rightHeap.peek()){
                totalCost += leftHeap.poll();
            }else{
                totalCost+= rightHeap.poll();
            }
        }

        return totalCost;
    }
}



/*
 * APPROACH: Two Min-Heaps & Two Pointers
 * 1. Maintain two min-heaps (leftHeap and rightHeap) to track the candidate 
 *    workers from the beginning and end of the array.
 * 2. Use two pointers (i and j) to keep the heaps filled up to the 'candidates' 
 *    limit during each hiring session.
 * 3. In each of the 'k' iterations, compare the minimum cost from both heaps, 
 *    hire the cheapest worker (prioritizing the left heap on a tie), and refill 
 *    the empty spot from the appropriate pointer.
 */