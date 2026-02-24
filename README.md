# JavaDSA

A collection of LeetCode-style problems solved in Java, organized by data structure and algorithm pattern.

---

## Algorithmic Patterns

### 1. Sliding Window
Maintain a variable-size or fixed-size window over a sequence and expand/shrink it to satisfy a condition, avoiding redundant recomputation.

**When to use:** Finding the longest/shortest subarray or substring that meets a constraint (no duplicate characters, contains all required characters, etc.).

**Examples in this repo:**
- `arrays/LongestSubstringNoDups.java` – longest substring without repeating characters (LC 3)
- `faangmustdo/MinWindowSubstring.java` – minimum window substring (LC 76)
- `LongestSubstringCharacterReplacement.java` – longest substring after character replacement (LC 424)

---

### 2. Two Pointers
Use two indices that move toward each other (or in the same direction) to process a sorted array or linked list in O(n) time instead of O(n²).

**When to use:** Pair-sum problems, removing duplicates, partitioning, or comparing two sequences.

**Examples in this repo:**
- `arrays/ThreeSum.java` – 3Sum (LC 15)
- `arrays/FourSum.java` – 4Sum (LC 18)
- `arrays/DutchFlag.java` – Dutch National Flag / sort colors (LC 75)
- `faangmustdo/TrappingRainwaterLc42.java` – trapping rainwater (LC 42)
- `faangmustdo/ContainerMaxWater.java` – container with most water (LC 11)
- `linkedlist/FindMidLL.java`, `linkedlist/FindCycleLL.java` – fast/slow pointer on linked lists

---

### 3. Binary Search
Repeatedly halve the search space on a **sorted** (or implicitly ordered) structure to find a target in O(log n).

**When to use:** Searching in sorted arrays, finding boundaries, or problems reducible to a monotonic condition.

**Examples in this repo:**
- `searching/BinarySearch.java` – classic binary search
- `blind75/MinRotatedArray.java` – minimum in rotated sorted array (LC 153)
- `faangmustdo/SearchRotatedSortedArray.java` – search in rotated sorted array (LC 33)
- `faangmustdo/MedianOfTwoSortedArrays.java` – median of two sorted arrays (LC 4)

---

### 4. Depth-First Search (DFS) / Breadth-First Search (BFS)
Graph/tree traversal strategies. DFS dives deep before backtracking; BFS explores level by level.

**When to use:** Tree/graph traversal, connected-component counting, shortest-path (BFS), or exhaustive exploration (DFS).

**Examples in this repo:**
- `trees/NumberOfIslands.java` – DFS flood-fill on a grid (LC 200)
- `trees/BTPreorderTraversal.java`, `BTInorderTraversal.java`, `BTPostorderTraversal.java` – tree traversals
- `faangmustdo/BTLevelOrderTraversal.java` – BFS level-order traversal (LC 102)
- `trees/NTCloneGraph.java` – clone a graph via DFS (LC 133)
- `faangmustdo/WordSearch.java` – word search on a grid (LC 79)

---

### 5. Backtracking
Incrementally build a candidate solution and abandon ("backtrack") it as soon as it cannot possibly lead to a valid answer.

**When to use:** Generating all permutations, combinations, subsets, or solving constraint-satisfaction problems (Sudoku, N-Queens).

**Examples in this repo:**
- `templates/patterns/BackTrackingTemplate.java` – reusable backtracking template
- `faangmustdo/ComboSum.java` – combination sum (LC 39)
- `faangmustdo/WordSearch.java` – word search via DFS + backtracking (LC 79)

---

### 6. Dynamic Programming (DP)
Break a problem into overlapping subproblems, solve each once, and store results to avoid repeated work.

**When to use:** Optimization problems (max/min), counting problems, or problems with optimal substructure and overlapping subproblems.

**Examples in this repo:**
- `faangmustdo/HouseRobber.java` – house robber (LC 198), O(1) space DP
- `faangmustdo/DecodeWays.java` – decode ways (LC 91)
- `faangmustdo/LongestCommonSubsequence.java` – LCS (LC 1143)
- `faangmustdo/MaxProdSubArray.java` – maximum product subarray (LC 152)
- `faangmustdo/MatrixUniquePaths.java` – unique paths (LC 62)
- `faangmustdo/JumpGame.java` – jump game (LC 55)
- `google/PascalsTriangleArrayDP.java` – Pascal's triangle (LC 118)
- `googletop50/WildcardMatching.java` – wildcard matching (LC 44)

---

### 7. Kadane's Algorithm
A specific DP pattern for finding the maximum subarray sum in O(n) by tracking the current running sum and resetting when it becomes negative.

**Examples in this repo:**
- `arrays/FindMaxSubArraySum.java` – maximum subarray (LC 53)

---

### 8. Divide and Conquer
Split the input into smaller parts, solve recursively, then combine results.

**When to use:** Sorting, tree problems, or problems that naturally decompose into independent subproblems.

**Examples in this repo:**
- `templates/sorting/MergesortTemplate.java` – merge sort
- `templates/sorting/QuicksortTemplate.java` – quicksort (Lomuto partition)
- `faangmustdo/MedianOfTwoSortedArrays.java` – binary search / divide and conquer (LC 4)

---

### 9. Greedy
Make the locally optimal choice at each step, trusting that a sequence of local optima yields a global optimum.

**When to use:** Interval scheduling, jump games, or problems with a provably greedy optimal substructure.

**Examples in this repo:**
- `faangmustdo/JumpGame.java` – jump game (LC 55)
- `faangmustdo/NonOverlappingIntervals.java` – non-overlapping intervals (LC 435)
- `arrays/MergeIntervalsArrays.java` – merge intervals (LC 56)
- `arrays/InsertInterval.java` – insert interval (LC 57)

---

### 10. Hash Map / Hash Set
Use a hash-based data structure to achieve O(1) average-time lookups, reducing nested-loop solutions to a single pass.

**When to use:** Two-sum style problems, frequency counting, anagram detection, or cycle detection.

**Examples in this repo:**
- `faangmustdo/TwoSumArray.java` – two sum (LC 1)
- `blind75/LongestConsecutiveSequence.java` – longest consecutive sequence (LC 128)
- `google/SubarraySumEqualsK.java` – subarray sum equals K (LC 560)
- `google/UniqueEmail.java` – unique email addresses (LC 929)

---

### 11. Tree / Graph Algorithms
Problems solved with standard tree or graph techniques such as DFS, BFS, lowest-common ancestor, serialization, or Morris traversal.

**Examples in this repo:**
- `faangmustdo/BTSerializeDeSerialize.java` – serialize/deserialize binary tree (LC 297)
- `blind75/BTLeastCommonAncestor.java` – LCA of binary tree (LC 236)
- `trees/DiameterOfBT.java` – diameter of binary tree (LC 543)
- `trees/TMorrisInorder.java` – Morris in-order traversal (O(1) space)
- `trees/TZigZagLevelOrder.java` – zigzag level-order traversal (LC 103)

---

### 12. Linked List Techniques
Classic linked-list manipulations using runners, dummy nodes, and in-place pointer reversal.

**Examples in this repo:**
- `linkedlist/FindCycleLL.java` – detect cycle (LC 141, Floyd's algorithm)
- `linkedlist/MergeTwoSortedLL.java` – merge two sorted lists (LC 21)
- `linkedlist/SortList.java` – sort list via merge sort (LC 148)
- `linkedlist/SwapNodePairsLL.java` – swap pairs (LC 24)

---

### 13. Bit Manipulation
Exploit binary representations to perform fast arithmetic, counting, or state-encoding operations.

**Examples in this repo:**
- `bitmanipulation/BitManipulationBasics.java` – XOR, AND, OR, shift tricks
- `ReverseBits.java` – reverse bits (LC 190)
- `SumOfTwoIntegers.java` – add without `+` operator (LC 371)
- `faangmustdo/CountingBits.java` – counting bits (LC 338)
- `faangmustdo/MissingNumber.java` – missing number via XOR (LC 268)

---

### 14. Prefix Sum / Difference Array
Precompute cumulative sums so that any range sum query is answered in O(1).

**Examples in this repo:**
- `google/SubarraySumEqualsK.java` – subarray sum equals K using prefix sums (LC 560)
- `google/MatrixBlockSum.java` – 2-D prefix sum (LC 1314)

---

### 15. Heap / Priority Queue
Use a min-heap or max-heap to efficiently access the smallest or largest element.

**Examples in this repo:**
- `faangmustdo/TopKElements.java` – top K frequent elements (LC 347)
- `neet150/FindKthLargestElement.java` – Kth largest element (LC 215)
- `blind75/MeetingRoomsTwo.java` – meeting rooms II (LC 253)
- `google/MedianFinder.java` – find median from data stream using two heaps (LC 295)

---

### 16. Cache / LRU & LFU
Design problems requiring O(1) get and put operations using combined hash map + doubly linked list structures.

**Examples in this repo:**
- `cache/LRUCache.java` – LRU cache (LC 146)
- `cache/LFUCache.java` – LFU cache (LC 460)

---

### 17. Trie (Prefix Tree)
A tree of characters used for efficient string prefix lookups, autocomplete, and word search.

**Examples in this repo:**
- `Trie.java` – insert, search, and startsWith (LC 208)

---

### 18. Matrix / Grid Manipulation
Problems that treat a 2-D array as a grid and apply in-place transformations or traversals.

**Examples in this repo:**
- `faangmustdo/RotateImage.java` – rotate image 90° (LC 48)
- `faangmustdo/SpiralMatrix.java` – spiral matrix (LC 54)
- `faangmustdo/MatrixSetZero.java` – set matrix zeroes (LC 73)
- `medium/ValidSudoku.java` – valid sudoku (LC 36)
- `BattleShips.java` – battleships in a board (LC 419)

---

## Package Overview

| Package | Focus |
|---|---|
| `arrays` | Array manipulation, intervals, sliding window |
| `linkedlist` | Linked list classics |
| `trees` | Binary tree / N-ary tree / graph traversal |
| `sorting` | Sorting algorithm implementations |
| `searching` | Binary search |
| `bitmanipulation` | Bit tricks |
| `cache` | LRU / LFU cache design |
| `faangmustdo` | High-priority FAANG interview problems |
| `blind75` | Blind 75 curated problem set |
| `google` | Google interview collection |
| `googletop50` | Google Top 50 problems |
| `microsoft` | Microsoft interview problems |
| `neet150` | NeetCode 150 problems |
| `hard` | Hard-level problems |
| `medium` | Medium-level problems |
| `templates` | Reusable algorithm templates (backtracking, quicksort, mergesort) |
| `util` | Shared utilities and benchmarking helpers |
