package com.app.collections.map;


public class CustomMap{
	private HashNode[] buckets;
	private Integer capacity;
	private Integer size;
	public CustomMap(Integer capacity){
		this.capacity=capacity;
		this.size=0;
		this.buckets=new HashNode[capacity];
	}
	public static void main(String[] args) {
		
	}
	public void put(Integer key,String value) {
		Integer index=getIndex(key);
		HashNode head=buckets[index];
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		size++;
		head=buckets[index];
		HashNode d=new HashNode(key,value);
		d.next=head;
		buckets[index]=d;
	}
	public String get(Integer key) {
		Integer index=getIndex(key);
		HashNode head=buckets[index];
		while(head!=null) {
			if(head.key.equals(key))
				return head.value;
			head=head.next;
		}
		return null;
	}
	public Integer getIndex(Integer key) {
		return key%capacity;
	}
}


class HashNode{
	
	Integer key;
	String value;
	HashNode next;
	
	public HashNode(Integer key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}