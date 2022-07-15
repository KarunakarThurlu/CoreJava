
package com.app.datastructuresandalgorithams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphWithLinkedList {
	
	
	private LinkedList<Integer>[] list;
	private Integer V;
	private Integer E;
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		System.out.println(" Vertices : "+V+" Edges : "+E +"\n");
		for (int i = 0; i <V; i++) {
			sb.append(i+" : ");
			for(Integer j : list[i]) {
				sb.append(j+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void BFS(int s) {
		Boolean[] visited=new Boolean[V];
		Arrays.fill(visited, false);
		Queue<Integer> q=new LinkedList<>();
		visited[s]=true;
		q.offer(s);
		while(!q.isEmpty()) {
			int u=q.poll();
			System.out.print(u+" ");
			for(Integer i:list[u]) {
				if(!visited[i]) {
					visited[i]=true;
					q.offer(i);
				}
			}
		}
	}
	
	public void DFS(int start) {
		boolean[] visited=new boolean[V];
		Stack<Integer> stack=new Stack<>();
		visited[start]=true;
		stack.push(start);
		while(!stack.isEmpty()) {
			int visitedNode=stack.pop();
			System.out.print(visitedNode +" ");
			for(int i:list[visitedNode]) {
				if(!visited[i]) {
					stack.push(i);
					visited[i]=true;
				}
			}
		}
	}
	
	public GraphWithLinkedList(Integer nodes) {
		this.list=new LinkedList[nodes];
		this.V=nodes;
		this.E=0;
		for(int i=0;i<nodes;i++) {
			list[i]=new LinkedList<>();
		}
	}
	public void addEdge(Integer from,Integer to) {
		list[from].add(to);
		list[to].add(from);
		E++;
	}
	public static void main(String[] args) {
		GraphWithLinkedList gll=new GraphWithLinkedList(5);
		gll.addEdge(0,1);
		gll.addEdge(1,2);
		gll.addEdge(3,2);
		gll.addEdge(0,3);
		gll.addEdge(2,4);
		
		gll.BFS(0);
		System.out.println();
		gll.DFS(0);
	}
	
	
}
