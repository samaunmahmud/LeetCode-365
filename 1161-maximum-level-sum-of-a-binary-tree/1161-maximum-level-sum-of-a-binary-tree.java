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