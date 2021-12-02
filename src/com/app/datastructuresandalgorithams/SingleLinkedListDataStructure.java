package com.app.datastructuresandalgorithams;


public class SingleLinkedListDataStructure {

	static Node<Integer> head=null;

	//Adding Data to start of HeadNode
	public static void addStartOfHead(Integer data) {
		Node<Integer> currentNode=new Node<>(data);
		currentNode.next=head;
		head=currentNode;
	}

	//Adding Data to end of HeadNode
	public static void addEndOfHead(Integer data) {
		Node<Integer> currentNode=new Node<>(data);
		if(head==null) {
			head=currentNode;
			return;
		}
		Node<Integer> current=head;
		while(null!=current.next) {
			current=current.next;
		}
		current.next=currentNode;
	}
	//Adding Data at specific position
	public static void addAtNthposition(Integer data,Integer position) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null || position==1) {
			dataNode.next=head;
			head=dataNode;
		}else {
			Node<Integer> temp=head;
			Integer count=1;
			while(count<position-1) {
				temp=temp.next;
				count++;
				if(temp.next==null)
					return;
			}
			Node<Integer> neaxtToTemp=temp.next;
			dataNode.next=neaxtToTemp;
			temp.next=dataNode;
		}
	}
	
	//Delete data at specific position
	public static void deleteNode(Integer data) {
		Node<Integer> temp=head;
		Node<Integer> previous=null;
		while(null!=temp.next) {
			previous=temp;
			temp=temp.next;
			if(temp.data==data) {
				previous=temp.next;
				return;
			}	
		}
	}
	public static void main(String... customLinkedListExample) {

		addEndOfHead(190);
		addEndOfHead(293);
		addEndOfHead(596);
		addEndOfHead(206);
		
		System.out.println(head);
		deleteNode(293);
		System.out.println(head);
		
	}

}


final class Node<T>{
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
