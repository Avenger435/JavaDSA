/**
 * 
 */
package com.java.dsa.util;

/**
 * 
 */
import java.util.function.Consumer;

public class ComplexityProfiler {

	// Executes a function and prints time + memory stats
	public static <T> void profile(String label, T input, Consumer<T> function) {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc(); // Suggest garbage collection for cleaner memory snapshot

		long startMem = runtime.totalMemory() - runtime.freeMemory();
		long startTime = System.nanoTime();

		function.accept(input); // Run the algorithm

		long endTime = System.nanoTime();
		long endMem = runtime.totalMemory() - runtime.freeMemory();

		System.out.println("[" + label + "]");
		System.out.println("Input Type: " + input.getClass().getName());
		System.out.println("Time (ns): " + (endTime - startTime));
		System.out.println("Memory (bytes): " + (endMem - startMem));
		System.out.println("----------------------------");
	}
}