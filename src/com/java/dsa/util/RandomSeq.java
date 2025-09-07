package com.java.dsa.util;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSeq {

	public static void main(String[] args) {

		// command line args
		int n = Integer.parseInt(args[0]);

		if (args.length == 1) {
			// generate and print n numbers between 0.0 and 1.0
			for (int i = 0; i < n; i++) {
				double x = StdRandom.uniformDouble(0.0, 1.0);
				StdOut.println(x);
			}

		} else if (args.length == 3) {
			double lo = Double.parseDouble(args[1]);
			double hi = Double.parseDouble(args[2]);

			// generate and print n numbers between lo and hi

			for (int i = 0; i < n; i++) {
				double x = StdRandom.uniformDouble(lo, hi);
				StdOut.printf("%.2f\n", x);
			}
		} else {
			throw new IllegalArgumentException("Invalid number for arguments");
		}

	}

}