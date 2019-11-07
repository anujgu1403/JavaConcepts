package com.java.concepts.graph;

public class GraphRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("DFS traversal: ");
		graph.DFS(1);
		
		System.out.println("\nBFS traversal: ");
		graph.BFS(1);

	}

}
