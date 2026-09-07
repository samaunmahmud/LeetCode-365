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