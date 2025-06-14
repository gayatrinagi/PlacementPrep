import java.util.*;

public class BST{
    private static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
             left=right=null;
        }
    }
    public static Node buildBST(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(val>root.data){
            root.right=buildBST(root.right,val);
        }else{
            root.left=buildBST(root.left,val);
        }
        return root;
    }
    static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    static  boolean search(Node root, int key){//O(H)= time complexity equal to height of tree
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }else if(root.data>key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }
    static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right,val);
        }else if(root.data>val){
            root.left=delete(root.left,val);
        }else{
            if(root.right==null && root.left==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            Node successor=inorderSuccessor(root.right);//find the inorder successor- smallest num in right subtree
            root.data=successor.data;//replace the data of root with its inorder successors data
            root.right=delete(root.right,successor.data);//recursively delete the successor node from its original position right subtree
        }
        return root;
    }
    static Node inorderSuccessor(Node root){
        while(root!=null && root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1,k2);
        }else if(root.data<k1){
            printInRange(root.left,k1,k2);
        }else{
            printInRange(root.right,k1,k2);
        }
    }
    public static void main(String[] args){

        int values[]={8,5,1,3,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=buildBST(root,values[i]);
        }
        // inorder(root);
        // System.out.print(search(root,15));
        delete(root,1);
        inorder(root);
        System.out.println();
        printInRange(root,5,12);
    }

}
