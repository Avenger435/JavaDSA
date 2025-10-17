package com.java.dsa.faangmustdo;

import java.util.ArrayList;
import java.util.List;

public class ColorSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 } };
		System.out.println("Can finish all courses: " + canFinish(numCourses, prerequisites));

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		// Create an adjacency list to represent the graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());

		}
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[1]).add(prerequisite[0]);

		}
		// Array to track the color of each node: 0 = unvisited, 1 = visiting, 2 =
		// visited
		int[] color = new int[numCourses];
		// Perform DFS for each course
		for (int i = 0; i < numCourses; i++) {
			if (color[i] == 0) {
				if (hasCycle(graph, color, i)) {
					return false; // Cycle detected, cannot finish all courses
				}
			}

		}

		return true; // No cycles detected, can finish all courses
	}

	private static boolean hasCycle(List<List<Integer>> graph, int[] color, int i) {
		if (color[i] == 1) {
			return true; // Cycle detected
		}

		if (color[i] == 2) {
			return false; // Already visited, no cycle from this node
		}
		color[i] = 1;
		// Mark the node as visiting
		for (int neighbor : graph.get(i)) {
			if (hasCycle(graph, color, neighbor)) {
				return true; // Cycle detected in the neighbor
			}
		}
		color[i] = 2; // Mark the node as visited
		return false; // No cycle detected from this node
	}
}
