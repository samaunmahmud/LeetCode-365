class Solution {



    private static class Node{
        String dest;
        double weight;

        Node(String dest, double weight){
            this.dest = dest;
            this.weight = weight;

        }
    }






    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Node>> graph =new HashMap<>();


        for(int i=0;i<equations.size();i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());


            graph.get(u).add(new Node(v, val));

            graph.get(v).add(new Node(u, 1.0/val));
        }


        double[] results = new double[queries.size()];


        for(int i =0;i<queries.size();i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if(!graph.containsKey(start)|| !graph.containsKey(end)){
                results[i]=-1.0;
            }else if(start.equals(end)){
                results[i]=1.0;
            }else{
                Set<String> visited = new HashSet<>();
                results[i]=dfs(start, end,1.0,graph,visited);
            }

        }
        return results;
        
    }

    private double dfs(String current, String target, double currentProduct, Map<String, List<Node>> graph, Set<String> visited){
        if(current.equals(target)){
            return currentProduct;
        }


        visited.add(current);


        for(Node neighbor: graph.get(current)){
            if(!visited.contains(neighbor.dest)){
                double result = dfs(neighbor.dest, target, currentProduct*neighbor.weight,graph, visited);

                if(result!= -1.0){
                    return result;
                }
            }
        }
        return -1.0;
    }



}




/**
 * Approach for Evaluate Division (Graph Traversal / DFS with Weights):
 * 
 * 1. Conceptual Framing (Equations as a Weighted Graph):
 *    - Treat variables (e.g., "a", "b", "c") as nodes in a graph.
 *    - Treat each equation `A / B = value` as a directed, weighted edge between node A and node B.
 *    - Because math works both ways, every equation creates a two-way relationship:
 *        a. Forward Path (A -> B): Multiplier is `value` (since A / B = value).
 *        b. Reverse Path (B -> A): Multiplier is `1.0 / value` (since B / A = 1 / value).
 * 
 * 2. Using a HashMap for String-Based Nodes:
 *    - Unlike numeric indices, nodes here are strings. A `HashMap<String, List<Node>>` acts 
 *      as a directory, mapping each variable name to a list of its connected neighbors.
 *    - A helper `Node` class stores both the destination variable string (`dest`) and the 
 *      division multiplier (`weight`).
 * 
 * 3. Handling Queries:
 *    - For each query `[start, end]`:
 *        a. If either variable doesn't exist in the graph, it's undefined, so return `-1.0`.
 *        b. If `start` and `end` are the same variable and exist, the answer is `1.0`.
 *        c. Otherwise, initialize a `HashSet` for visited tracking and launch a DFS traversal.
 * 
 * 4. Depth-First Search (DFS) Traversal with Multipliers:
 *    - Maintain a running product (`currentProduct`) that starts at `1.0`.
 *    - Mark the `current` variable as visited.
 *    - Base Case: If `current` matches the `target` variable, return the accumulated `currentProduct`.
 *    - Inspect Neighbors: Iterate through all connected neighbors of the current variable.
 *    - Recursion: For any unvisited neighbor, recursively call DFS while multiplying the running 
 *      product by the neighbor's edge weight (`currentProduct * neighbor.weight`).
 *    - If a valid path is found (not `-1.0`), bubble that result back up. If a dead end is hit, return `-1.0`.
 */