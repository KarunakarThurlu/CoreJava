package com.app.datastructuresandalgorithams;

public class TreeNode<T> {
	T  data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "[ "+ left+"<--"+data+"-->" + right + " ]";
	}
	
	

}
