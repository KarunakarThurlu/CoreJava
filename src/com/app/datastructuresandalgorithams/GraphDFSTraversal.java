package com.app.datastructuresandalgorithams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GraphDFSTraversal {
/*Graph is a collection of vertices and edges. G(V,E)
 * 
 * 
 * 	
 */
	private  List<Integer>[] adjList;
	private  Integer V;
	private  Integer E;
	
	public GraphDFSTraversal(Integer vertices) {
		this.adjList = new ArrayList[vertices];
		this.V=vertices;
		this.E=0;
		for(int i=0;i<vertices;i++) {
			adjList[i]=new ArrayList<>();
		}
	}
	
	@Override
	public String toString() {
		System.out.println("Graph Contains "+V+" Vertices And "+E +" Edges");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<V;i++) {
			sb.append("Vertex :"+i+" Corresponding Edges :");
			for(Integer node:adjList[i]) {
				sb.append("["+i+","+node+"]");
			}
			sb.append("\n");
			
		}
		return sb.toString();
	}
	
	public  void addEdge(Integer from,Integer to) {
		adjList[from].add(to);
		adjList[to].add(from);
		E++;
	}

	public void DFStraversal(Integer start) {
		Boolean[] visited= new Boolean[V];
		Arrays.fill(visited, false);
		Stack<Integer> stack=new Stack<>();
		
		visited[start]=true;
		stack.push(start);
		while(!stack.isEmpty()) {
			Integer visitedNode=stack.pop();
			System.out.print(visitedNode+" ");
			for(Integer i :adjList[visitedNode]) {
				if(!visited[i]) {
					visited[i]=true;
					stack.push(i);
				}
			}
		}
		
	}
	
	public static void main(String ...DFS_Traversal) {
		GraphDFSTraversal dfs=new GraphDFSTraversal(8);
		dfs.addEdge(0,1);
		dfs.addEdge(1,2);
		dfs.addEdge(2,3);
		dfs.addEdge(3,0);
		dfs.addEdge(1,7);
		dfs.addEdge(3,5);
		dfs.addEdge(4,2);
		dfs.addEdge(4,6);
		dfs.addEdge(5,6);
		
		dfs.DFStraversal(3);
		System.out.println();
		System.out.println(dfs);
	}
}
