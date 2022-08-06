package com.app.datastructuresandalgorithams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeDataStructure {
	/*1). BinaryTree is a hierarchical data structure
	 *2). In Binary Tree each Node have utmost 2 child Nodes.(i.e either 0 OR 1 OR 2)
	 *3). Each Node contains Data Element and corresponding Left child,Right child nodes.
	 *4). 
	 * 
	 * 
	 *Full Binary Tree:-A full binary tree is a tree with every node has either 0 or 2 children. No node will have only one child.
	 *================
	 * 
	 *Complete Binary Tree:- A tree where every level fully filled (have 2 children) except maybe the last level. For the complete binary tree, we fill the last level from left to right.
	 *==================== 
	 * 
	 *Perfect Binary Tree:- All the leaves have the same depth or same level.
	 *===================== 
	 */
	private static TreeNode<Integer> root=null;

	public static void insert(List<Integer> list) {
		for(Integer data: list)
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
	public static List<Integer> inOrderTraversal(TreeNode<Integer> rootNode,List<Integer> list) {
		if(rootNode!=null) {
			inOrderTraversal(rootNode.left,list);
			list.add(rootNode.data);
			inOrderTraversal(rootNode.right,list);
		}
		return list;
	}
	//PostOrder traversal
	public static void postOrderTraversal(TreeNode<Integer> rootNode) {
		if(rootNode!=null) {
			postOrderTraversal(rootNode.left);
			postOrderTraversal(rootNode.right);
			System.out.print(rootNode.data+" ");
		}
	}
	//Level order traversal
	public static void levelOrderTraversal(TreeNode<Integer> rootNode) {
		List<List<Integer>> result=new ArrayList<>();
		if(rootNode==null) {
			System.out.println(result);
		}
		Queue<TreeNode<Integer>> q=new LinkedList<>();
		q.add(rootNode);
		while(!q.isEmpty()) {
			List<Integer> level=new ArrayList<>();
			int size=q.size();
			for(int i=0;i<size;i++) {
				TreeNode<Integer> currentNode=q.peek();
				q.remove();
				level.add(currentNode.data);
				if(currentNode.left!=null)
					q.add(currentNode.left);
				if(currentNode.right!=null)
					q.add(currentNode.right);
			}
			result.add(level);
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
			else if(root.left!=null && root.right!=null) {
				root.data=findMinFromRightSubTree(root.right);
				root.right=delete(root.right,root.data);
			}else {
				return null;
			}
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
	/**
	 * Validate Given Tree is BST or not
	 * @param rootNode
	 * @return
	 */
	public static Boolean validateBinaryTree(TreeNode<Integer> rootNode) {
		return validateBinaryTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public static Boolean validateBinaryTree(TreeNode<Integer> root,Integer min,Integer max) {
		if(root==null)
			return true;
		if(root.data<=min || root.data>=max)
			return false;
		return  validateBinaryTree(root.left,min,root.data) && validateBinaryTree(root.right,root.data,max);
	}
	
	/**
	 * 
	 * @param rootNode
	 * @return
	 */
	public static Boolean symtricTreeOrNot(TreeNode<Integer> rootNode) {
		return symtricTreeOrNot(rootNode,rootNode);
	}
	public static Boolean symtricTreeOrNot(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		return root1.data==root2.data && symtricTreeOrNot(root1.left,root2.right) && symtricTreeOrNot(root1.right,root2.left);
	}
	
	/**
	 * 
	 * @param rootNode
	 * @return
	 */
	public static Integer findingMaxDepthOfBST(TreeNode<Integer> rootNode) {
		if(rootNode==null)
			return 0;
		int left=findingMaxDepthOfBST(rootNode.left);
		int right=findingMaxDepthOfBST(rootNode.right);
		
		return Math.max(left, right)+1;
	}
	
	/**
	 * Left View Of BST
	 * @param rootNode
	 * @return
	 */
	static int viewMaxLevel=0;
	public static List<Integer> leftViewOfBST(TreeNode<Integer> rootNode){
		List<Integer> list=new ArrayList<>();
		return leftViewOfBST(rootNode,list,1);
	}
	public static List<Integer> leftViewOfBST(TreeNode<Integer> rootNode,List<Integer> list,Integer currentLevel){
		if(rootNode==null)
			return list;
		if(viewMaxLevel<currentLevel) {
			list.add(rootNode.data);
			viewMaxLevel=currentLevel;
		}
		leftViewOfBST(rootNode.left,list,currentLevel+1);
		leftViewOfBST(rootNode.right,list,currentLevel+1);
		return list;
	}

	/**
	 * Find Height of BST
	 * @param root
	 * @return
	 */
	public static Integer getHeightOfBST(TreeNode<Integer> root) {
		//if Tree is empty then height is  0 (Base Case) 
		if(root==null)
			return 0;
		//If Tree is not empty then height = 1 + Max of left subtree and right subtree
		return 1+(Math.max(getHeightOfBST(root.left), getHeightOfBST(root.right)));
	}
	/**
	 * Convert given sorted array into BinarySearchTree
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static TreeNode<Integer> convertSortedArrayIntoBST(int[] nums,int left,int right){
		if(left>right) {
			return null;
		}
		int mid=(left+right)/2;
		TreeNode<Integer> t=new TreeNode<>(nums[mid]);
		t.left=convertSortedArrayIntoBST(nums,left,mid-1);
		t.right=convertSortedArrayIntoBST(nums,mid+1,right);
		return t;

	}
	/**
	 * Find Maximum path Sum value
	 * @param root
	 * @return
	 */
	private static  Integer maxPathSumVal=Integer.MIN_VALUE;
	public static Integer maxPathSum(TreeNode<Integer> root) {
		if(root==null)
			return 0;
		Integer left=Math.max(maxPathSum(root.left),0);
		Integer right=Math.max(maxPathSum(root.right),0);
		maxPathSumVal=Math.max(maxPathSumVal,left+right+root.data);
		return Math.max(left, right)+root.data;
	}
	
	/**
	 * Invert given Binary Tree
	 * @param root
	 * @return
	 */
	public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root){
		if(root!=null) {
			TreeNode<Integer> left=root.left;
			TreeNode<Integer> right=root.right;
			root.right=left;
			root.left=right;
			invertBinaryTree(root.left);
			invertBinaryTree(root.right);
		}
		return root;
	}

	static TreeNode<Integer> fbstLList=new TreeNode<>(0);
	public static TreeNode<Integer> flattenBSTreeToLList(TreeNode<Integer> root){
		 convertFlattenBSTreeToLList(root);
		 return fbstLList;
	}
	
	private static void convertFlattenBSTreeToLList(TreeNode<Integer> root) {
		if(root==null)
			return ;
		
		TreeNode<Integer> left=root.left;
		TreeNode<Integer> right=root.right;
		fbstLList.left=null;
		fbstLList.right=root;
		fbstLList=fbstLList.right;
		convertFlattenBSTreeToLList(left);
		convertFlattenBSTreeToLList(right);
		
	}
	
	public static TreeNode<Integer> mergeTwoBSTrees(TreeNode<Integer> root1,TreeNode<Integer> root2){
		if(root1==null)
			return root2;
		if(root2==null)
			return root1;
		root1.data=root1.data+root2.data;
		root1.left=mergeTwoBSTrees(root1.left,root2.left);
		root1.right=mergeTwoBSTrees(root1.right,root2.right);
		return root1;
	}
	public static Boolean pathSum(TreeNode<Integer> root,Integer targetSum) {
		if(root==null) {
			return false;
		}
		if(root.left==null && root.right==null) {
			return root.data==targetSum;
		}
		return pathSum(root.left,targetSum-root.data) || pathSum(root.right,targetSum-root.data) ;
	}
	
	public Boolean sameBST(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null && root2!=null) {
			return false;
		}
		if(root1!=null && root2==null) {
			return false;
		}
		return root1.data==root2.data && sameBST(root1.left,root2.left)  && sameBST(root1.right,root2.right);
	}
	
	public TreeNode<Integer> balanceBST(TreeNode<Integer> root){
		List<Integer> list=inOrderTraversal(root,new ArrayList<>());
		return balanceBST(list,0,list.size()-1);
	}
	
	private TreeNode<Integer> balanceBST(List<Integer> list, int left, int right) {
		if(left>right)
			return null;
		Integer mid=left+(right-left)/2;
		TreeNode<Integer> t=new TreeNode<>(mid);
		t.left=balanceBST(list,left,mid-1);
		t.right=balanceBST(list,mid+1,right);
		return t;
	}
	
	public Integer minDepthOfBST(TreeNode<Integer> root) {
		if(root ==null) {
			return 0;
		}
		if(root.left==null) {
			return minDepthOfBST(root.right)+1;
		}
		if(root.right==null){
			return minDepthOfBST(root.left)+1;
		}
		return Math.min(minDepthOfBST(root.left), minDepthOfBST(root.right))+1;
	}
	
	public TreeNode<Integer> lcaOfBST(TreeNode<Integer> root,TreeNode<Integer> p,TreeNode<Integer> q){
		if(root==null)
			return null;
		if(root==p || root ==q)
			return root;
		TreeNode<Integer> lca1=lcaOfBST(root.left,p,q);
		TreeNode<Integer> lca2=lcaOfBST(root.right,p,q);
		if(lca1!=null && lca2!=null) {
			return root;
		}
		return lca1!=null?lca1:lca2;
	}
	public static void main(String[] args) {
		
		insert(List.of(10,2,12,8,11,1,3));
		/*System.out.println("PreOrder Trversal :");
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
		*/
		int[] a= {1,43,5,6,7,8,990};
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		} 
		System.out.println(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}



