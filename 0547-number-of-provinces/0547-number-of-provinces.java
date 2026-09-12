class Solution {

    private void dfs(int i,int[][] adj,boolean[] vis){

        vis[i]=true;

        for(int j=0;j<adj.length;j++){

            if(adj[i][j] ==1 && !vis[j]){
                dfs(j,adj,vis);
            }

        }

    }




    public int findCircleNum(int[][] isConnected) {

        int numOfProvinces =0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,isConnected,vis);
                numOfProvinces++;
            }
        }

        return numOfProvinces;
        
    }
}