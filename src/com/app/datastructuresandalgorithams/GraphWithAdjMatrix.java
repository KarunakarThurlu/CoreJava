package com.app.datastructuresandalgorithams;

import java.util.LinkedList;
import java.util.Queue;

public class GraphWithAdjMatrix {
	
	public int[][] adjmatrix;
	public int V;
	public int E;
	
	public void addEdge(int from,int to) {
		adjmatrix[from][to]=1;
		adjmatrix[to][from]=1;
		E++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		System.out.println(" Vertices : "+V+" Edges : "+E +"\n");
		for (int i = 0; i <V; i++) {
			sb.append(i+" : ");
			for(Integer j : adjmatrix[i]) {
				sb.append(j+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void BFS(int s) {
		boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        
        while (!q.isEmpty()){
        	int vis = q.poll();
            System.out.print(vis + " ");
            for(int i = 0; i < V; i++){
                if ((!visited[i])){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
	public GraphWithAdjMatrix(int nodes) {
		this.adjmatrix=new int[nodes][nodes];
		this.V=nodes;
		this.E=0;
	}
	public static void main(String[] args) {
		GraphWithAdjMatrix gds=new GraphWithAdjMatrix(5);
		gds.addEdge(0,1);
		gds.addEdge(1,2);
		gds.addEdge(2,3);
		gds.addEdge(3,0);
		gds.addEdge(2,4);
		gds.BFS(4);
		
	}
	
}
