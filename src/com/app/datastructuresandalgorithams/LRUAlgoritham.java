package com.app.datastructuresandalgorithams;

import java.util.Objects;

public class LRUAlgoritham {


	public static  Node<Integer> head = null;
	public static Node<Integer> tail = null;
	public final Integer CAPACITY = 5;
	public Integer size=0;

	public static void main(String[] args) {
		LRUAlgoritham lru=new LRUAlgoritham();
		lru.addElement(6);
		lru.addElement(7);
		lru.addElement(8);
		lru.addElement(9);
		lru.addElement(10);
		System.out.println(head);
		lru.addElement(11);
		System.out.println(head);
	}
	public Integer getElement(Integer data) {
		Node<Integer> tempHead=head;
		while(tempHead!=null) {
			Node<Integer> temp=tempHead;
			tempHead=tempHead.next;
			if(temp.data==data) {
				if(temp.prev==null) {
					return temp.data;
				}else {
					if(temp.prev!=null) {
						
					}
				}
			}
		}
		return null;
	}
	public void addElement(Integer data) {
		Node<Integer> dataNode = new Node<>(data);
		if(head==null) {
			head=tail=dataNode;
			size++;
		}else {
			if(Boolean.FALSE.equals(checkElementAlreadyExist(data))){
				if(Objects.equals(size, CAPACITY)) {
					Node<Integer> tempTail=tail.prev;
					tempTail.next=dataNode;
					dataNode.prev=tempTail;
				}else {
					Node<Integer> tempHead= head;
					while(tempHead.next!=null) {
						tempHead=tempHead.next;
					}
					dataNode.prev=tempHead;
					tempHead.next=dataNode;
					tail=dataNode;
					size++;
				}
			}
		}
	}
	
	public Boolean checkElementAlreadyExist(Integer data) {
		Node<Integer> tempHead= head;
		while(tempHead!=null) {
			if(Objects.equals(tempHead.data, data))
				return true;
			tempHead=tempHead.next;
		}
		return false;
	}

	static class Node<T>{
		T data;
		Node<T> prev;
		Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
			this.prev = null;
			this.next = null;
		}

		@Override
		public String toString() {
			return  "[ "+data + " |*<--]-->*" + next + "";
		}

			
	}
}
