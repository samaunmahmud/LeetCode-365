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