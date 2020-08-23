package leetcode.crossingpath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CrossingPath {

    static Map<Integer, Set<Integer>> visitedPointsMap;
    static boolean visitedTwice;

    public static boolean isPathCrossing(String path) {
        // 1 <= path.length <= 10^4
        if (path.length() < 1 || path.length() >= (int) Math.pow(10, 4)) {
            throw new IllegalArgumentException("1 <= path.length <= 10^4");
        }
        if (!path.matches("^[NSEW]+$")) {
            throw new IllegalArgumentException("path will only consist of characters N, S, E, W");
        }

        int[] lastVisitedPoint = new int[2];
        lastVisitedPoint[0] = 0;
        lastVisitedPoint[1] = 0;
        visitedPointsMap = new HashMap<>();
        Set<Integer> zeroSet = new HashSet<>();
        zeroSet.add(0);
        visitedPointsMap.put(0, zeroSet);
        for (int i = 0; i < path.length(); i++) {
            Set<Integer> currentSet;
            int newVisitedYPoint;
            if (path.charAt(i) == 'N') {
                newVisitedYPoint = ++lastVisitedPoint[1];
                currentSet = visitedPointsMap.get(lastVisitedPoint[0]);
                if (currentSet != null) {
                    if (!currentSet.add(newVisitedYPoint)) {
                        visitedTwice = true;
                    }
                } else {
                    currentSet = new HashSet<>();
                    visitedPointsMap.put(lastVisitedPoint[0], currentSet);
                }

            } else if (path.charAt(i) == 'S') {
                newVisitedYPoint = --lastVisitedPoint[1];
                currentSet = visitedPointsMap.get(lastVisitedPoint[0]);
                if (currentSet != null) {
                    if (!currentSet.add(newVisitedYPoint)) {
                        visitedTwice = true;
                    }
                } else {
                    currentSet = new HashSet<>();
                    visitedPointsMap.put(lastVisitedPoint[0], currentSet);
                }

            } else if (path.charAt(i) == 'E') {
                newVisitedYPoint = ++lastVisitedPoint[0];
                currentSet = visitedPointsMap.get(lastVisitedPoint[0]);
                if (currentSet != null) {
                    if (!currentSet.add(newVisitedYPoint)) {
                        visitedTwice = true;
                    }
                } else {
                    currentSet = new HashSet<>();
                    visitedPointsMap.put(lastVisitedPoint[0], currentSet);
                }

            } else if (path.charAt(i) == 'W') {
                newVisitedYPoint = --lastVisitedPoint[0];
                currentSet = visitedPointsMap.get(lastVisitedPoint[0]);
                if (currentSet != null) {
                    if (!currentSet.add(newVisitedYPoint)) {
                        visitedTwice = true;
                    }
                } else {
                    currentSet = new HashSet<>();
                    visitedPointsMap.put(lastVisitedPoint[0], currentSet);
                }
            }
        }
        return visitedTwice;
    }
}