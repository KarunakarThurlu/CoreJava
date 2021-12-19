package com.app.datastructuresandalgorithams;

public class QueueDataStructure {

	private static  Node<Integer> head=null;
	private static Integer size=0;

	public static void add(Integer data) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null) {
			head=dataNode;
			size++;
		}else {
			Node<Integer> currentNode=head;
			while(null!=currentNode.next) {
				currentNode=currentNode.next;
			}
			currentNode.next=dataNode;
			size++;
		}
	}


	public static Integer size() {
		return size;
	}

	public static Integer peek() {
		if(head!=null) {
			return head.data;
		}else {
			return null;
		}
	}

	public static Integer poll() {
		Node<Integer> dataNode=head;
		if(head==null) {
			return null;
		}else {
			Integer data=dataNode.data;
			head=dataNode.next;
			size--;
			return data;
		}
	}
	public static void main(String[] args) {
		add(10);
		add(11);
		add(8);
		add(19);
		System.out.println(head);
		System.out.println(peek());
		System.out.println(size());
		System.out.println(poll());
		System.out.println(head);
		System.out.println(size());
	}
}
