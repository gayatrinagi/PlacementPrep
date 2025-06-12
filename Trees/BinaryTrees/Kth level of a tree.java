package dsaplacement;
import java.util.*;
public class binaryTrees {
	static class Node{//creating a node class
		int value;
		Node left;//left of node
		Node right;//right of node
		Node(int value){
			this.value=value;
			this.left=null;
			this.right=null;
		}
	}
	static class BinaryTree{
		static int index=-1;
		public static Node buildTree(int nodes[]) {
			index++;
			if(index>=nodes.length || nodes[index]==-1) {
				return null;
			}
			Node newNode=new Node(nodes[index]);//create a new node
			newNode.left=buildTree(nodes);//recursively builds leftsubtree 
			newNode.right=buildTree(nodes);//recursively builds rightsubtree
			return newNode;
			}
		static void atK(Node node,int level, int k) {
			if(node==null) {
				return;
			}
			if(level==k) {
				System.out.print(node.value+" ");
				return;
			}
			atK(node.left,level+1,k);
			atK(node.right,level+1,k);
		}
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree=new BinaryTree();
		Node root=tree.buildTree(nodes);
		int k=3;
		tree.atK(root,1,k);
		
	}

}
