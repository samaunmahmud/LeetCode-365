class Solution {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> map = new HashMap<>();


        for(int[] arr: grid){

            String key = Arrays.toString(arr);
            map.put(key, map.getOrDefault(key,0) +1);

        }
        int count =0;


        for(int i=0;i<grid.length;i++){
            int[] col = new int[grid.length];

            for(int j=0;j<grid.length;j++){
                col[j]= grid[j][i];
            }

            String colS = Arrays.toString(col);

            count = count+ map.getOrDefault(colS,0);
        }


        return count;
        
    }
}