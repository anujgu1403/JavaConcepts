package com.java.concepts.graph;

import java.util.Comparator;

public class Node implements Comparator<Node> {

	private int node;
	private int cost;

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Node() {

	}

	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.cost > o2.cost) {
			return 1;
		} else if (o1.cost < o2.cost) {
			return -1;
		} else {
			return 0;
		}
	}

}
