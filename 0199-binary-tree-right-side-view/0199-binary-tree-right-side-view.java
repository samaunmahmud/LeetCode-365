/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        

        List<Integer> result = new ArrayList<>();
         if(root == null){
            return result;
        }

        Queue<TreeNode> helper = new LinkedList<>();

        helper.offer(root);



        while(!helper.isEmpty()){

            int levelSize = helper.size();

            for(int i=0;i<levelSize;i++){
                TreeNode current = helper.poll();

                if(i==levelSize-1){
                    result.add(current.val);
                }
                if(current.left!=null){
                    helper.offer(current.left);
                }

                if(current.right!=null){
                    helper.offer(current.right);
                }

            }
           

        }
        return result;


        
    }
}


/**
 * Visualizing Binary Tree Right Side View (BFS / Level-Order Traversal):
 * 
 * Example Tree:
 *        1  (Level 0)
 *      /   \
 *     2     3  (Level 1)
 *      \     \
 *       5     4  (Level 2)
 * 
 * Step-by-Step Trace:
 * 
 * 1. Setup & Initialization:
 *    - Queue starts with root node: queue = [1]
 *    - result = []
 * 
 * 2. Processing Level 0:
 *    - queue.size() = 1 (levelSize = 1)
 *    - i = 0: Poll node 1. Since i == levelSize - 1 (0 == 0), it's the last node of this level! 
 *      Add 1 to result. result = [1]
 *    - Push children of 1 into the queue: queue becomes [2, 3]
 * 
 * 3. Processing Level 1:
 *    - queue.size() = 2 (levelSize = 2)
 *    - i = 0: Poll node 2. Not the last node (0 != 1). Push its child (5). queue = [3, 5]
 *    - i = 1: Poll node 3. Since i == levelSize - 1 (1 == 1), it's the last node of this level! 
 *      Add 3 to result. result = [1, 3]
 *    - Push child of 3 into the queue: queue becomes [5, 4]
 * 
 * 4. Processing Level 2:
 *    - queue.size() = 2 (levelSize = 2)
 *    - i = 0: Poll node 5. Not the last node. queue = [4]
 *    - i = 1: Poll node 4. Since i == levelSize - 1 (1 == 1), it's the last node of this level! 
 *      Add 4 to result. result = [1, 3, 4]
 * 
 * 5. Completion:
 *    - Queue is now empty. The while loop ends.
 *    - Returns final result list: [1, 3, 4]
 */