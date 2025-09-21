package com.java.dsa.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.java.dsa.util.NTNode;

public class NTMaxDepth {

	public static void main(String[] args) {

		NTMaxDepth solver = new NTMaxDepth();

        // Edge case: null root
        assert solver.maxDepth(null) == 0;
        assert solver.maxDepthIterative(null) == 0;

        // Edge case: single node
        NTNode single = new NTNode(1, new ArrayList<>());
        assert solver.maxDepth(single) == 1;
        assert solver.maxDepthIterative(single) == 1;

        // Tree: root with multiple children, some with their own children
        NTNode leaf1 = new NTNode(2, new ArrayList<>());
        NTNode leaf2 = new NTNode(3, new ArrayList<>());
        NTNode child = new NTNode(4, Arrays.asList(leaf1, leaf2));
        NTNode root = new NTNode(5, Arrays.asList(child, new NTNode(6, new ArrayList<>())));
        assert solver.maxDepth(root) == 3;
        assert solver.maxDepthIterative(root) == 3;

        // Tree: deep single branch
        NTNode deep = new NTNode(1, Arrays.asList(
            new NTNode(2, Arrays.asList(
                new NTNode(3, Arrays.asList(
                    new NTNode(4, new ArrayList<>())
                ))
            ))
        ));
        assert solver.maxDepth(deep) == 4;
        assert solver.maxDepthIterative(deep) == 4;

        System.out.println("All test cases passed.");
        
        solver.maxDepthIterative(deep);
	}

	public int maxDepth(NTNode root) {
		// Edge case
		if (root == null)
			return 0;

		// track max
		int ans = 0;
		for (NTNode child : root.neighbors) {
			// recursively call on the nodes;
			ans = Math.max(ans, maxDepth(child));
		}
		// add root to ans
		return ans + 1;

	}

	public int maxDepthIterative(NTNode root) {
		if (root == null)
			return 0;

		//Queue to keep track of elements.
		Queue<NTNode> queue = new LinkedList<>();
		
		int depth = 0;
		//offer root to the queue.
		queue.offer(root);

		//iterate while queue has elements.
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				NTNode node = queue.poll();
				if (node != null) {
					for (NTNode child : node.neighbors) {
						queue.offer(child);
					}
				}
			}
			depth++;
		}

		return depth;
	}

}
