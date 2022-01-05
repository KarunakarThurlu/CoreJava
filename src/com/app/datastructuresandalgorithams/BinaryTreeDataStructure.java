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
				preTraversal(rootNode.left);
				preTraversal(rootNode.right);
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
	//PostOrder traversal
	public static void postOrderTraversal(TreeNode<Integer> rootNode) {
		if(rootNode!=null) {
			postOrderTraversal(rootNode.left);
			postOrderTraversal(rootNode.right);
			System.out.print(rootNode.data+" ");
		}
	}
	
	//Deleting a node from  tree
	public static void delete(Integer data) {
		root=delete(root,data);
	}
	
	private static TreeNode<Integer> delete(TreeNode<Integer> root, Integer data) {
		if(root==null) {
			return root;
		}
		if(data<root.data)
			root.left=delete(root.left,data);
		else if(data>root.data)
			root.right=delete(root.right, data);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			root.data=findMinFromRightSubTree(root.right);
			root.right=delete(root.right,root.data);
		}
		return root;
	}

	private static Integer findMinFromRightSubTree(TreeNode<Integer> node) {
		Integer minValue=node.data;
		while(node.left!=null) {
			minValue=node.data;
			node=node.left;
		}
		return minValue;
	}

	public static void main(String[] args) {
		insert(45);
		insert(10);
		insert(90);
		insert(7);
		insert(12);
		insert(100);
		System.out.println("PreOrder Trversal :");
		preTraversal(root);
		System.out.println();
		System.out.println("InOrder Trversal :");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("PostOrder Trversal :");
		postOrderTraversal(root);
		System.out.println();
		System.out.println("Deleting 10 ");
		delete(10);
		System.out.println();
		preTraversal(root);
		
	}
}
