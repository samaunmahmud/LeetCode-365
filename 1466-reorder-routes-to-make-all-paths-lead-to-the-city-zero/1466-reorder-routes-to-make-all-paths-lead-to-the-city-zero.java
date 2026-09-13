class Solution {
     private int reorderCount =0;
    public int minReorder(int n, int[][] connections) {


        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] conn: connections){
            int u =conn[0];
            int v = conn[1];

            graph.get(u).add(new int[]{v,1});
            graph.get(v).add(new int[]{u,0});



        }

        boolean[] visited = new boolean[n];

        dfs(0,graph,visited);
        return reorderCount;



        
    }


    private void dfs(int node, List<List<int[]>> graph, boolean[] visited){

        visited[node] = true;


        for(int[] neighbor: graph.get(node)){
            int nextCity = neighbor[0];
            int cost = neighbor[1];


            if(!visited[nextCity]){
                reorderCount+=cost;

                dfs(nextCity, graph, visited);
            }
        }

    }
}


/**
 * Approach for Reorder Routes to Make All Paths Lead to the City Zero (Graph DFS + Reversal Tracking):
 * 
 * 1. Conceptual Framing & Strategy:
 *    - Treat the cities and one-way roads as a connected tree network (graph).
 *    - Instead of trying to find paths from every random city toward the capital (City 0), 
 *      start the traversal directly at City 0 and crawl outward to every connected node.
 * 
 * 2. Building the Two-Way Adjacency List:
 *    - Physical roads are one-way, but graph traversal requires moving in both directions 
 *      to explore the entire tree. For every given connection `[u, v]`:
 *        a. Store `[v, 1]` on city `u`'s list: Moving from `u` to `v` goes *away* from the capital, 
 *           meaning traffic is flowing the wrong way and will require a flip (cost = 1).
 *        b. Store `[u, 0]` on city `v`'s list: Moving from `v` to `u` goes *toward* the capital, 
 *           meaning traffic flows correctly and needs no flips (cost = 0).
 * 
 * 3. Depth-First Search (DFS) Traversal:
 *    - Maintain a boolean `visited` array to prevent infinite loops between connected cities.
 *    - Maintain a global counter (`reorderCount`) to track total edge flips.
 *    - For the current city, loop through all its neighbors:
 *        a. Skip any neighbor that has already been visited.
 *        b. Add the neighbor's edge cost (`1` or `0`) to `reorderCount`.
 *        c. Recursively call DFS on the unvisited neighbor to continue expanding outward.
 * 
 * 4. Final Result:
 *    - Once the DFS recursion completes across all branches from City 0, `reorderCount` holds 
 *      the exact minimum number of road reversals required for all cities to reach the capital.
 */