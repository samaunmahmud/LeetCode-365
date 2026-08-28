class RecentCounter {

    int counter;

    Queue<Integer> store = new ArrayDeque<>();

    public RecentCounter() {

        counter=0;
        
    }
    
    public int ping(int t) {
        store.add(t);
        boolean check =true;
        

        while(check){
            if(store.peek()>=(t-3000)){
                check =false;
            }else{
                store.remove();
            }
        }

        return store.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */