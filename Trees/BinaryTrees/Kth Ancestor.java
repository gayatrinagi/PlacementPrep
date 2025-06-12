import java.util.*;
public class kth_Ancestor{
     static class Node{
        
        int data;
        Node left,right;
        Node(int data){
           
            this.data=data;
            
            left=right=null;
        }
     }
     static boolean getPath(Node root,int key,ArrayList<Node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==key){
            return true;
        }
        boolean leftPath=getPath(root.left,key,path);
        boolean rightPath=getPath(root.right,key,path);
        if(leftPath|| rightPath){
            return true;
        }
        path.remove(path.size()-1);
        return false;
     }
     static int kthAncestor1(Node root,int key,int k){//FIRST APPROACH- SPACE COMP=> O(N) 
        ArrayList<Node> path=new ArrayList<>();
        boolean found= getPath(root,key,path);
        int i=path.size()-1;
        if(!found || path.size()<=k){
            return -1;
        }
        return path.get(path.size()-k-1).data;

     }
     static int kthAncestor2(Node root,int key,int k){//SECOND APPROACH- SPACE COMP=> O(1) 
        if(root==null){
            return -1;
        }
        if(root.data==key){//node 
            return 0;
        }
        int leftDist=kthAncestor2(root.left,key,k);
         int rightDist=kthAncestor2(root.right,key,k);
         if(leftDist==-1 && rightDist==-1){
            return -1;
         }
         int max=Math.max(leftDist,rightDist);//valid dist
         int ans=max+1;
         if(ans==k){
            System.out.print(root.data);
         }
         return max+1;
     }
     static Node newNode(int data){
        return new Node(data);
     }
    public static void main(String[] args){
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        int k = 2;
        int node = 5;

        
        kthAncestor2(root,node,k);
    
               
        }
}


