package algorithms;

import metrics.PerformanceTracker;

public class BoyerMooreMajorityVote {

    public static int findMajority(int[] nums, PerformanceTracker tracker) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int candidate = 0, count = 0;
        tracker.start();

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        tracker.stop();
        return candidate;
    }
}
