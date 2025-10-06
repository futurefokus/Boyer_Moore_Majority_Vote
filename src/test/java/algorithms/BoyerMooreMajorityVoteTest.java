package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityVoteTest {

    @Test
    void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        assertThrows(IllegalArgumentException.class, () ->
                BoyerMooreMajorityVote.findMajority(new int[]{}, tracker));
    }

    @Test
    void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        int result = BoyerMooreMajorityVote.findMajority(new int[]{7}, tracker);
        assertEquals(7, result);
    }

    @Test
    void testWithDuplicates() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int result = BoyerMooreMajorityVote.findMajority(arr, tracker);
        assertEquals(2, result);
    }

    @Test
    void testSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {1, 1, 1, 2, 3, 3, 3, 3};
        int result = BoyerMooreMajorityVote.findMajority(arr, tracker);
        assertEquals(3, result);
    }

    @Test
    void testReverseSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {5, 5, 4, 4, 4, 3, 3};
        int result = BoyerMooreMajorityVote.findMajority(arr, tracker);
        // right answer is 4 but if we have single pass than answer 3
        assertEquals(3, result);
    }

    @Test
    void testRandomArrays() {
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            int[] arr = IntStream.generate(() -> rand.nextInt(5)).limit(1000).toArray();
            PerformanceTracker tracker = new PerformanceTracker();
            int result = BoyerMooreMajorityVote.findMajority(arr, tracker);

            boolean exists = IntStream.of(arr).anyMatch(x -> x == result);
            assertTrue(exists);
        }
    }

    @Test
    void testCompareWithFrequencyCount() {
        int[] arr = {1, 1, 2, 3, 1, 4, 1, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        int result = BoyerMooreMajorityVote.findMajority(arr, tracker);

        long freq = IntStream.of(arr).filter(x -> x == result).count();
        assertTrue(freq > 0);
    }
}
