/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    // Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1, int n2) {
        // Your code here
        if(root==null|| root.data==n1|| root.data==n2){
            return root;
        } 
        Node leftlca=lca(root.left,n1,n2);
        Node rightlca=lca(root.right,n1,n2);
        //leftlca had some valid value but rightlca turns out to null
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
        
    }
}
