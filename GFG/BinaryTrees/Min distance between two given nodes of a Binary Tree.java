// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
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
    int lcadist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist=lcadist(root.left,n);
        int rightDist=lcadist(root.right,n);
        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist==-1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    int findDist(Node root, int a, int b) {
       Node lca=lca(root,a, b);
       return lcadist(lca,a)+lcadist(lca,b);
        
    }
}
