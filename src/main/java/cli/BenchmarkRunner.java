package cli;

import algorithms.BoyerMooreMajorityVote;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        System.out.println("\n=== Boyer–Moore Majority Vote Benchmark ===");

        int[] sizes = {100, 1_000, 10_000, 100_000};
        Random rand = new Random(42);

        for (int size : sizes) {
            int[] arr = new int[size];
            int majority = rand.nextInt(10);

            for (int i = 0; i < size; i++) {
                arr[i] = (i < size / 2 + 1) ? majority : rand.nextInt(10);
            }

            PerformanceTracker tracker = new PerformanceTracker();
            int result = BoyerMooreMajorityVote.findMajority(arr, tracker);

            tracker.printMetrics("Size " + size);
            tracker.writeMetrics(size, result);
        }

        System.out.println("\nBenchmark complete! Results saved/appended to performance/bench_results.csv");
    }
}
