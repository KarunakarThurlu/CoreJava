package com.app.datastructuresandalgorithams;

import java.util.Arrays;
import java.util.stream.Collectors;

//Queue Data Structure Using LinkedList
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
		System.out.println("================Queue Implentation using LinkedLidt==================");
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
		
		
		System.out.println("================Queue Implentation using Array=======================");
	
		QueueWithArray qa=new QueueWithArray();
		qa.offer(10);
		qa.offer(30);
		qa.offer(20);
		qa.offer(59);
		
		System.out.println(qa);
		System.out.println(qa.poll());
		System.out.println(qa);
		qa.offer(100);
		System.out.println(qa);
		System.out.println("peek Element : "+qa.peek());
		System.out.println(qa);
		System.out.println("Queue of Size : "+qa.size()+"  Capacity : "+qa.capacity());
	}
}

//Queue Data Structure using Dynamic Array
class QueueWithArray{

	private Integer queue[];
	private Integer capacity=0;

	public String toString() {
		return Arrays.stream(queue).map(e->e).collect(Collectors.toList()).toString();
	}
	
	QueueWithArray(){
		queue=new Integer[10];
	}

	public void offer(Integer element) {
		queue[capacity]=element;
		capacity++;
	}

	public Integer poll() {
		Integer frontElement=queue[0];
		for(int i=1;i<=capacity;i++) {
			queue[i-1]=queue[i];
		}
		capacity--;
		return frontElement;
	}

	public Integer peek() {
		return queue[0];
	}

	public Integer capacity() {
		return queue.length;
	}

	public Integer size() {
		return capacity;
	}
}
