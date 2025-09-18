package com.java.dsa.util;

public class BackTrackingTemplate{


void backtrack(List<Integer> path, int[] options) {
    if (isSolution(path)) {
        process(path);
        return;
    }

    for (int option : options) {
        if (isValid(path, option)) {
            path.add(option);
            backtrack(path, options);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
}