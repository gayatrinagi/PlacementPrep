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
    public void inorder(TreeNode root,ArrayList<Integer> seq){
        if(root==null){
            return;
        }
        inorder(root.left,seq);
        seq.add(root.val);
        inorder(root.right,seq);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> seq=new ArrayList<>();
        inorder(root,seq);
        return seq.get(k-1);
    }
}
