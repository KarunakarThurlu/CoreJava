package com.app.datastructuresandalgorithams;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSTraversal {
	private int[][] adjMatrix;
	private int V;
	private int E;

	public GraphBFSTraversal(int vertices) {
		this.adjMatrix=new int[vertices][vertices];
		this.V=vertices;
		this.E=0;
	}

	public void addEdge(int from,int to) {
		adjMatrix[from][to]=1;
		adjMatrix[to][from]=1;
		E++;
	}

	public void BFS(int start) {
		boolean[] visited=new boolean[V];
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(start);
		visited[start]=true;
		while(!queue.isEmpty()) {
			int visitedVertex=queue.poll();
			System.out.print(visitedVertex+" -->");
			for(int i=0;i<V;i++) {

				if(adjMatrix[visitedVertex][i]==1 && (!visited[i])) {
					visited[i]=true;
					queue.offer(i);
				}
			}
		}
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		System.out.println("Graph Contains  "+V+" Vertices and "+E+ "Edges");
		for(int i=0;i<V;i++) {
			sb.append(i+" ");
			for(int j: adjMatrix[i]) {
				sb.append(j+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		GraphBFSTraversal bfs=new GraphBFSTraversal(5);
		bfs.addEdge(0, 1);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 0);
		bfs.addEdge(2, 4);

		bfs.BFS(3);

	}
}
