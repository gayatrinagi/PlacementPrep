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
    public void inorder(TreeNode root, ArrayList<Integer> seq){
        if(root==null){
            return;
        }
        inorder(root.left,seq);
        seq.add(root.val);
        inorder(root.right,seq);
    }
    public TreeNode createBST(ArrayList<Integer> seq,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(seq.get(mid));
        root.left=createBST(seq,start,mid-1);
        root.right=createBST(seq,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> seq=new ArrayList<>();
        inorder(root,seq);//inorder sequence creates a sorted arraylist - then same q as 108. convert sorted array to balanced bst
        return createBST(seq,0,seq.size()-1);
    }
}
