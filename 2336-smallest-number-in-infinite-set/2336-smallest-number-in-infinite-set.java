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