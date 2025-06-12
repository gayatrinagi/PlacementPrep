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
     static int kthAncestor(Node root,int key,int k){//space complexity- O(N)- better recursive approach
        ArrayList<Node> path=new ArrayList<>();
        boolean found= getPath(root,key,path);
        int i=path.size()-1;
        if(!found || path.size()<=k){
            return -1;
        }
        return path.get(path.size()-k-1).data;

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
        int k = 1;
        int node = 3;

        // print kth ancestor of given node
        int ancestor= kthAncestor(root,node,k);
        if (ancestor == -1)  System.out.println("Kth ancestor does not exist");
        else  System.out.println("The " + k + "th ancestor of node " + node + " is: " + ancestor);
               
        }
}


