class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0]=true;


        while(!queue.isEmpty()){
            int currentRoom = queue.poll();


            for(int key: rooms.get(currentRoom)){

                if(!visited[key]){
                    visited[key]=true;
                    queue.offer(key);
                }
            }
        }


        for(boolean isVisited: visited){
            if(!isVisited){
                return false;
            }
        }

        return true;
        
    }
}