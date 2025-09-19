package com.java.dsa.templates.patterns;

import java.util.List;

/**
 * BackTrackingTemplate provides a general-purpose structure for solving backtracking problems.
 * 
 * Use cases:
 * - Generating all permutations or combinations of a set
 * - Solving constraint satisfaction problems (e.g., N-Queens, Sudoku)
 * - Finding subsets, partitions, or paths in graphs
 * - Any problem where you need to explore all possible configurations and backtrack upon invalid or complete solutions
 *
 * To use, override or implement isSolution, process, and isValid methods for your specific problem.
 */
public class BackTrackingTemplate {

    /**
     * The main backtracking method.
     * @param path    The current partial solution (path).
     * @param options The set of options to explore at each step.
     */
    void backtrack(List<Integer> path, int[] options) {
        // If the current path is a complete solution, process it.
        if (isSolution(path)) {
            process(path);
            return;
        }

        // Try each available option.
        for (int option : options) {
            // Check if adding this option is valid.
            if (isValid(path, option)) {
                path.add(option); // Choose
                backtrack(path, options); // Explore
                path.remove(path.size() - 1); // Un-choose (backtrack)
            }
        }
    }

    /**
     * Determines if the current path is a valid solution.
     * Override this method with problem-specific logic.
     * @param path The current path.
     * @return true if path is a solution, false otherwise.
     */
    boolean isSolution(List<Integer> path) {
        // Implement problem-specific solution check.
        return true;
    }

    /**
     * Processes a valid solution path.
     * Override this method to handle the solution (e.g., print, collect, etc.).
     * @param path The solution path.
     */
    void process(List<Integer> path) {
        // Implement logic to process the solution.
    }

    /**
     * Checks if an option can be added to the current path.
     * Override this method with problem-specific constraints.
     * @param path   The current path.
     * @param option The option to check.
     * @return true if the option is valid, false otherwise.
     */
    boolean isValid(List<Integer> path, int option) {
        // Implement logic to check if option is valid.
        return true;
    }

}