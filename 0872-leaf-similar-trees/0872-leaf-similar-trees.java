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




/*

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Collect leaves for both trees
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        // Compare the two leaf lists
        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        // Check if the current node is a leaf (no left and no right child)
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        // Recursively traverse left first, then right
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
}



*/
