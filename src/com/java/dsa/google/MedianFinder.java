/**
 * MedianFinder is a data structure that supports adding numbers and finding the median efficiently.
 * It uses two heaps (a max-heap for the smaller half and a min-heap for the larger half) to maintain the order of elements.
 *
 * <p>Usage example:
 * <pre>
 *     MedianFinder obj = new MedianFinder();
 *     obj.addNum(num);
 *     double median = obj.findMedian();
 * </pre>
 *
 * <ul>
 *   <li>{@link #addNum(int)}: Adds a number into the data structure.</li>
 *   <li>{@link #findMedian()}: Returns the median of all elements so far.</li>
 * </ul>
 *
 * <p>Internally, the class maintains two priority queues:
 * <ul>
 *   <li>smallHeap: A max-heap (implemented using a PriorityQueue with reversed order) to store the smaller half of the numbers.</li>
 *   <li>largeHeap: A min-heap to store the larger half of the numbers.</li>
 * </ul>
 *
 * <p>The balancing logic ensures that the size difference between the two heaps is at most one,
 * and all elements in smallHeap are less than or equal to those in largeHeap.
 *
 * <p>Time Complexity:
 * <ul>
 *   <li>addNum: O(log n)</li>
 *   <li>findMedian: O(1)</li>
 * </ul>
 */
package com.java.dsa.google;

import java.util.Queue;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();

        int[] nums = { 2, 3, 5 };
        for (int i = 0; i < nums.length; i++) {
            obj.addNum(nums[i]);
        }
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }

    private Queue<Integer> smallHeap;
    private Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        smallHeap.add(num);
        if ((smallHeap.size() - largeHeap.size() > 1)
                || !largeHeap.isEmpty() && (smallHeap.peek() > largeHeap.peek())) {
            largeHeap.add(smallHeap.poll());

        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */