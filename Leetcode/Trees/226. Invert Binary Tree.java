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

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode mirror=new TreeNode(root.val);
        mirror.left=invertTree(root.right);
        mirror.right=invertTree(root.left);
        return mirror;
    }
}
