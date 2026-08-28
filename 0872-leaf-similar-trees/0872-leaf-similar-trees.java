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

    ArrayList<Integer> a1 = new ArrayList<>();

    ArrayList<Integer> a2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        store1(root1);
        store2(root2);

        return a1.equals(a2);


        
    }



    public void store1(TreeNode root){

        if(root == null){
            return;
        }


        if(root.left == null && root.right== null){
            a1.add(root.val);
            return;
        }

        store1(root.left);
        store1(root.right);



    }


    public void store2(TreeNode root){

        if(root == null){
            return;
        }


        if(root.left == null && root.right== null){
            a2.add(root.val);
            return;
        }

        store2(root.left);
        store2(root.right);



    }
}