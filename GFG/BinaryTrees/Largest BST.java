// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
            
        }
        
    }
     static int maxBST=0;
    
    static Info largest(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=  largest(root.left);//left ki info nikali recusively
        Info rightInfo=largest(root.right);//right ki info nikali recursively
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
         if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        //khud bhi bst and subtree bhi bst
        
      return new Info(false,size,min,max);//root node not valid bst  
        
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        maxBST = 0; // reset before computation
        largest(root);
        return maxBST;
        
    }
}
