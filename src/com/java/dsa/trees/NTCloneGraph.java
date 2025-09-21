package com.java.dsa.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.java.dsa.util.NTNode;

public class NTCloneGraph {

	public static void main(String[] args) {

		int[][] adjList = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };

		NTNode[] nodes = new NTNode[adjList.length];

		for (int i = 0; i < adjList.length; i++) {
			nodes[i] = new NTNode(i + 1, new ArrayList<>());
		}

		for (int i = 0; i < adjList.length; i++) {
			for (int neighbor : adjList[i]) {
				nodes[i].neighbors.add(nodes[neighbor - 1]);
			}
		}

		NTNode start = nodes[0];

		NTCloneGraph cloner = new NTCloneGraph();
		cloner.cloneGraph(start);
	}

	public NTNode cloneGraph(NTNode node) {

		if (node == null)
			return null;

		Map<NTNode, NTNode> map = new HashMap<>();
		return cloneDFS(node, map);

	}

	private NTNode cloneDFS(NTNode node, Map<NTNode, NTNode> map) {

		if (map.containsKey(node))
			return map.get(node);

		NTNode clone = new NTNode(node.val, new ArrayList<>());
		map.put(node, clone);

		for (NTNode neighbor : node.neighbors) {
			clone.neighbors.add(cloneDFS(neighbor, map));
		}

		return clone;
	}
}
