package com.java.concepts.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkistraShortestPath {
	private int V;
	private Set<Integer> settled;
	private int dist[];
	private PriorityQueue<Node> pQueue;
	List<List<Node>> adj;

	public DijkistraShortestPath(int v) {
		this.V = v;
		dist = new int[v];
		settled = new HashSet<Integer>();
		pQueue = new PriorityQueue<Node>(V, new Node());
	}

	public void dikjistraAlgo(List<List<Node>> adj, int src) {
		this.adj = adj;

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// add src element into pQueue
		pQueue.add(new Node(src, 0));

		// distance to the source is 0
		dist[src] = 0;

		while (settled.size() != V) {
			// remove the minimum distance node from pQueue
			int u = pQueue.remove().getNode();
			// add node whose distance is finalized
			settled.add(u);
			processNeighbours(u);
		}
	}

	public void processNeighbours(int u) {
		int edgeDistance = -1;
		int newDistance = -1;

		for (int i = 0; i < adj.get(u).size(); i++) {
			Node node = adj.get(u).get(i);

			if (!settled.contains(node.getNode())) {
				edgeDistance = node.getCost();
				newDistance = dist[u] + edgeDistance;
				if (newDistance < dist[node.getNode()]) {
					dist[node.getNode()] = newDistance;
				}
				pQueue.add(new Node(node.getNode(), dist[node.getNode()]));
			}
		}
	}

	public static void main(String aa[]) {

		int V = 5;
		int source = 0;

		List<List<Node>> adj = new ArrayList<List<Node>>();

		// initialize each node for every node
		for (int i = 0; i < V; i++) {
			List<Node> item = new ArrayList<Node>();
			adj.add(item);
		}

		adj.get(0).add(new Node(1, 2));
		adj.get(0).add(new Node(2, 13));
		adj.get(0).add(new Node(3, 22));
		adj.get(0).add(new Node(4, 8));
		adj.get(2).add(new Node(1, 12));
		adj.get(2).add(new Node(3, 7));

		DijkistraShortestPath dj = new DijkistraShortestPath(V);
		dj.dikjistraAlgo(adj, source);

		// print shortest path
		System.out.println("Shortest path: ");
		for (int i = 0; i < dj.dist.length; i++) {
			System.out.println(source + " to " + i + " is " + dj.dist[i] + " ");

		}
	}

}
