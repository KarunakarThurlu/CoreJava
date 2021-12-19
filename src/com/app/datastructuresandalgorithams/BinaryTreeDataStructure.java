package com.app.datastructuresandalgorithams;

public class BinaryTreeDataStructure {

	private static TreeNode<Integer> root=null;

	public static void insert(Integer data) {
		root=insertRecursive(root,data);
	}

	private static TreeNode<Integer> insertRecursive(TreeNode<Integer> root, Integer data) {
		if(root==null) 
			return new TreeNode<>(data);
		if(data<root.data)
			root.left=insertRecursive(root.left,data);
		else if(data>root.data)
			root.right=insertRecursive(root.right,data);
		return root;
	}

	public static Boolean search(Integer key) {
		TreeNode<Integer> currentTreeNode=searchRecursive(root,key);
		return currentTreeNode!=null;
	}

	private static TreeNode<Integer> searchRecursive(TreeNode<Integer> root, Integer key) {
		if(root==null || root.data==key)
			return root;
		else if(key<root.data)
			return searchRecursive(root.left,key);
		return searchRecursive(root.right,key);
	}

	//PreOrder traversal
		public static void preTraversal(TreeNode<Integer> rootNode) {
			if(rootNode!=null) {	
				System.out.print(rootNode.data+" ");
				inOrderTraversal(rootNode.left);
				inOrderTraversal(rootNode.right);
			}
		}
	//InOrder traversal
	public static void inOrderTraversal(TreeNode<Integer> rootNode) {
		
		if(rootNode!=null) {
			inOrderTraversal(rootNode.left);
			System.out.print(rootNode.data+" ");
			inOrderTraversal(rootNode.right);
		}
	}
	public static void postOrderTraversal(TreeNode<Integer> rootNode) {
		if(rootNode!=null) {
			postOrderTraversal(rootNode.left);
			postOrderTraversal(rootNode.right);
			System.out.print(rootNode.data+" ");
		}
	}
	
	public static void main(String[] args) {
		insert(10);
		insert(8);
		insert(7);
		insert(17);
		insert(9);
		insert(11);
		System.out.println("PreOrder Trversal :");
		preTraversal(root);
		System.out.println();
		System.out.println("InOrder Trversal :");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("PostOrder Trversal :");
		postOrderTraversal(root);
		
	}
}
