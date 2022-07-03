package com.app.datastructuresandalgorithams;

import java.util.HashMap;
import java.util.Map;

public class LRUAlgoritham {


	public Node head = null;
	public Node tail = null;
	public Integer CAPACITY ;
	public Integer SIZE;
	Map<Integer, Node> cache;
	
	LRUAlgoritham(int capacity){
		this.CAPACITY=capacity;
		this.SIZE=0;
		cache=new HashMap<>(capacity);
		this.head=new Node(0,0);
		this.tail=new Node(0,0);
		head.next=tail;
		tail.prev=head;
	}
	public static void main(String[] args) {
		
	}
    public int get(int key) {
    	if(!cache.containsKey(key)) {
    		return -1;
    	}
    	Node d=cache.get(key);
    	updateList(d);
    	return d.val;
    }
	public void put(int key,int val){
		if(cache.containsKey(key)) {
			Node temp=cache.get(val);
			temp.val=val;
			updateList(temp);
		}else {
			SIZE++;
			if(SIZE>CAPACITY) {
				cache.remove(tail.prev.key);
				remove(tail.prev);
				SIZE--;
			}
			Node dataNode=new Node(key,val);
			insert(dataNode);
			cache.put(key, dataNode);
		}
	}
	//7439090141
	private void updateList(Node temp) {
		remove(temp);
		insert(temp);
	}

	private void insert(Node temp) {
		temp.next=head.next;
		temp.next.prev=temp;
		head.next=temp;
		temp.prev=head;
	}
	private void remove(Node temp) {
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;	
	}

	static class Node{
		int key;
		int val;
		Node prev;
		Node next;

		public Node(int key, int val) {
			super();
			this.key = key;
			this.val = val;
		}

	}
}
