class SmallestInfiniteSet {

    Set<Integer> infiniteSet = new HashSet<>();
    PriorityQueue<Integer> store = new PriorityQueue<>();
    int k=1;

   

    public SmallestInfiniteSet() {

        infiniteSet.clear();
        store.clear();
        k=1;
        
    }
    
    public int popSmallest() {
        if(!store.isEmpty()){
            
            return store.poll();

        }

        return k++;
        
    }
    
    public void addBack(int num) {
        if(num<k && !store.contains(num)){
            store.add(num);
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */






 /**
 * Approach for Smallest Number in Infinite Set (Min-Heap + Tracking Set):
 * 
 * 1. State & Initialization:
 *    - Maintain a baseline counter `k` starting at 1 to generate sequential numbers (1, 2, 3, ...).
 *    - Use a Min-Heap (`store`) to keep track of any numbers that were popped and later 
 *      added back, ensuring the smallest recycled numbers are always prioritized.
 * 
 * 2. popSmallest() Logic:
 *    - Check the min-heap first. If it is not empty, pull and return the smallest 
 *      recycled number using `.poll()`.
 *    - If the heap is empty, no numbers are waiting in the backlog, so return 
 *      the current baseline `k` and increment it.
 * 
 * 3. addBack(int num) Logic:
 *    - Validate that the number being added back is actually less than the current 
 *      baseline `k` (meaning it was previously removed) and is not already present in the heap.
 *    - If valid, add the number back into the min-heap so it can be re-issued in future pop operations.
 */