package com.java.dsa.apple;

// HitCounter class implements a simple hit counter that tracks the number of hits within the last 'windowSize' time units.
// It uses two arrays of size 'windowSize' for efficient storage and retrieval using modular arithmetic.
public class HitCounter {

	private final int windowSize;

	public static void main(String[] args) {
		// Example usage: Create a HitCounter instance with window size 300, record hits, and query total hits in the last 300 units.
		HitCounter hitCounter = new HitCounter(300);
		hitCounter.hit(1);
		hitCounter.hit(2);
		hitCounter.hit(3);
		System.out.println(hitCounter.getHits(4)); // return 3
		hitCounter.hit(300);
		System.out.println(hitCounter.getHits(300)); // return 4
		System.out.println(hitCounter.getHits(301)); // return 3
		
	}

	// Constructor: Initializes the HitCounter with arrays of the specified window size.
	public HitCounter(int windowSize) {
		this.windowSize = windowSize;
		this.timestamps = new int[windowSize];
		this.hits = new int[windowSize];
	}

	// Array to store timestamps, indexed by timestamp % windowSize.
	private int[] timestamps;
	// Array to store hit counts corresponding to each timestamp index.
	private int[] hits;
	
	// Records a hit at the given timestamp.
	// Uses modulo windowSize to map timestamp to an index, incrementing if same timestamp, else resetting.
	public void hit(int timestamp) {
		final int i = timestamp % windowSize;
		if(timestamps[i] == timestamp) {
			++hits[i];
		} else {
			timestamps[i] = timestamp;
			hits[i] = 1;
		}
	}

	// Returns the total number of hits in the past windowSize time units from the given timestamp.
	// Iterates through all indices, summing hits where timestamp - stored_timestamp < windowSize.
	public int getHits(int timestamp) {
		int countHits = 0;
		for(int i = 0; i < windowSize; i++) {
			if(timestamp - timestamps[i] < windowSize) {
				countHits += hits[i];
			}
		}
		return countHits;
	}
}