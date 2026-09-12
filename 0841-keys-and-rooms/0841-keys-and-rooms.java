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


/**
 * Approach for Keys and Rooms (Graph Traversal / BFS):
 * 
 * 1. State Tracking & Initialization:
 *    - Treat the rooms and keys as a directed graph where visiting a room gives you edges (keys) to other nodes (rooms).
 *    - Maintain a boolean array (`visited`) to keep track of which rooms have been successfully unlocked and entered.
 *    - Use a Queue to manage the BFS traversal, starting by adding room 0 and marking it as visited.
 * 
 * 2. Breadth-First Search (BFS) Traversal:
 *    - While there are rooms in the queue, dequeue the current room to explore it.
 *    - Iterate through all the keys found inside this current room.
 *    - For each key, check if the corresponding room has been visited. If not, mark it as visited 
 *      and enqueue it so its keys can be collected in subsequent steps.
 * 
 * 3. Final Verification:
 *    - After the queue is empty (meaning all accessible rooms have been explored), iterate through 
 *      the `visited` array.
 *    - If any room remains marked as `false`, it means it was unreachable, so return `false`. 
 *    - If all rooms are marked `true`, the traversal was successful, so return `true`.
 */