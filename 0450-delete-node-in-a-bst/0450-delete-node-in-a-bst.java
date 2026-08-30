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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }



        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minRoot = findSmallest(root.right);

            root.val = minRoot.val;

            root.right = deleteNode(root.right, root.val);

        }

        return root;
        
    }


    private TreeNode findSmallest(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }
}



// 1. Base case: If the tree is empty, return null.
// 2. Search phase: Use BST rules to find the node (go left if key < root.val, right if key > root.val).
// 3. Deletion phase (once the node is found):
//    - Case 1 & 2 (0 or 1 child): Return the non-null child (or null) to bypass the current node.
//    - Case 3 (2 children): Find the minimum value in the right subtree (successor),
//      copy its value into the current node, and recursively delete that duplicate node below.
// 4. Return the updated root reference to maintain tree connections.