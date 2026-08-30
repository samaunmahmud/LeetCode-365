class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> store = new PriorityQueue<>(Collections.reverseOrder());


        for(int i: nums){
            store.add(i);
        }

       
        

       for (int j = 1; j < k; j++) {
            store.poll();
        }

        return store.peek();




        
    }
}


/**
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            
            // If the heap size exceeds k, remove the smallest element.
            // This ensures we only keep the 'k' largest elements in the heap.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is now the kth largest element
        return minHeap.peek();
    }
}

 */