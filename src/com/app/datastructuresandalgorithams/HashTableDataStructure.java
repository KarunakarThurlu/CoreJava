package com.app.datastructuresandalgorithams;

public class HashTableDataStructure {
	int[] a=new int[4];
	private HashNode[] buckets;
	private Integer size;
	private Integer capacity;
	
	public HashTableDataStructure(Integer capacity) {
		this.buckets=new HashNode[capacity];
		this.size=0;
		this.capacity=capacity;
	}
	
	public Integer getIndex(Integer key) {
		return key%capacity;
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
		Integer index = getIndex(key);
		HashNode head = buckets[index];
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
		}
		return null;
	}
	
	public Boolean remove(Integer key) {
		Integer index=getIndex(key);
		HashNode head=buckets[index];
		if(head.key.equals(key)) {
			head=head.next;
			buckets[index]=head;
			size--;
			return true;
		}else {
			HashNode t=head;
			while(t.next!=null) {
				HashNode p=t;
				t=t.next;
				if(p.key.equals(key)) {
					p.next=t.next;
					buckets[index]=head;
					size--;
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean isEmpty() {
		return size==0;
	}
	
	public Integer size() {
		return size;
	}
	
	public static void main(String[] args) {
		HashTableDataStructure ht=new HashTableDataStructure(16);
		ht.put(1,"foo");
		ht.put(2,"zoo");
		ht.put(3,"soo");
		System.out.println(ht.get(3));
	}
}
class HashNode{
	Integer key;
	String value;
	HashNode next;
	public HashNode(Integer key,String value) {
		this.key=key;
		this.value=value;
		this.next=null;
	}
}