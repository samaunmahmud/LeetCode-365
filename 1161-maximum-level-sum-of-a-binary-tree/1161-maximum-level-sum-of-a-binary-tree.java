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
    public int maxLevelSum(TreeNode root) {

        if(root.left==null && root.right == null){
            return 1;
        }

        int maxSum=Integer.MIN_VALUE;
        Queue<TreeNode> helper = new LinkedList<>();

        helper.offer(root);
        
        int k=1;
        int result =1;

        while(!helper.isEmpty()){
            int length = helper.size();

            
            int sum =0;

            for(int i=0;i<length;i++){
                TreeNode node = helper.poll();
                sum = sum+node.val;

                if(node.left!= null){
                    helper.offer(node.left);
                }

                if(node.right!=null){
                    helper.offer(node.right);
                }

                
               


            }
            
            
            if(sum>maxSum){
                maxSum = sum;
                result =k;
            }
            k++;

            
        }

        return result;
        
    }
}


/**
 * Visualizing Maximum Level Sum of a Binary Tree (BFS / Level-Order Traversal):
 * 
 * Example Tree:
 *        1   (Level 1, sum = 1)
 *      /   \
 *     7     0   (Level 2, sum = 7 + 0 = 7)
 *    / \
 *   7  -8   (Level 3, sum = 7 + (-8) = -1)
 * 
 * Step-by-Step Trace:
 * 
 * 1. Setup & Initialization:
 *    - Queue starts with root node: helper = [1]
 *    - maxSum = Integer.MIN_VALUE, k = 1 (current level), result = 1
 * 
 * 2. Processing Level 1 (k = 1):
 *    - length = helper.size() = 1
 *    - Poll node 1. sum = 1. Push its children (7, 0). helper becomes [7, 0]
 *    - Since sum (1) > maxSum, update maxSum = 1, result = 1.
 *    - Increment k: k becomes 2.
 * 
 * 3. Processing Level 2 (k = 2):
 *    - length = helper.size() = 2
 *    - Poll node 7. sum = 7. Push its children (7, -8). helper becomes [0, 7, -8]
 *    - Poll node 0. sum = 7 + 0 = 7. helper becomes [7, -8]
 *    - Since sum (7) > maxSum (1), update maxSum = 7, result = 2.
 *    - Increment k: k becomes 3.
 * 
 * 4. Processing Level 3 (k = 3):
 *    - length = helper.size() = 2
 *    - Poll node 7. sum = 7. helper becomes [-8]
 *    - Poll node -8. sum = 7 + (-8) = -1. helper becomes []
 *    - sum (-1) is not greater than maxSum (7), so maxSum and result remain unchanged.
 *    - Increment k: k becomes 4.
 * 
 * 5. Completion:
 *    - Queue is now empty. The while loop ends.
 *    - Returns final result level: 2
 */