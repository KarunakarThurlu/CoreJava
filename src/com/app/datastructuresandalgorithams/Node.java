package com.app.datastructuresandalgorithams;

public class Node<T>{
	T data;
	Node<T> next;

	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "[ " + data + " | *-]--->" + next + "";
	}
}
