package com.java.concepts.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	// no of vertices
	private int V;
	// Array of list of adjacency vertices representation
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	// To add the vertex in graph
	public void addEdge(int v1, int v2) {
		adj[v1].add(v2);
	}

	// recursive DFS traversal
	public void dfsTraversal(int vertex, boolean visited[]) {
		// Mark given vertex as visited
		visited[vertex] = true;
		System.out.print(vertex + " ");

		Iterator<Integer> i = adj[vertex].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				dfsTraversal(n, visited);
			}
		}
	}

	public void DFS(int vertex) {
		boolean visited[] = new boolean[V];
		dfsTraversal(vertex, visited);

	}

	// recursive BFS traversal
	public void BFS(int s) {
		// to mark all vertices as non visited
		boolean visited[] = new boolean[V];
		// Queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();

				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}
}
