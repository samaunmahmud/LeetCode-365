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
    public int goodNodes(TreeNode root) {

        return goodDfs(root, root.val);
        
    }



    private int goodDfs(TreeNode root, int immediateParent){


        if(root == null){
            return 0;
        }



        int count =0;

        if(root.val>= immediateParent){
            count++;
            immediateParent = root.val;
        }

        count= count + goodDfs(root.left, immediateParent);
        count = count+ goodDfs(root.right, immediateParent);

        return count;


    }
}