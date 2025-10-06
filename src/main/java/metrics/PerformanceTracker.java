package metrics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long startTime;
    private long endTime;
    private long memoryBefore;
    private long memoryAfter;

    private static final File perfDir = new File("performance");
    private static final File csvFile = new File(perfDir, "bench_results.csv");

    static {
        if (!perfDir.exists()) {
            perfDir.mkdirs();
        }
    }

    public void start() {
        System.gc();
        memoryBefore = getUsedMemory();
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
        memoryAfter = getUsedMemory();
    }

    public double getElapsedTimeMs() {
        return (endTime - startTime) / 1_000_000.0;
    }

    public long getMemoryUsedKB() {
        return (memoryAfter - memoryBefore) / 1024;
    }

    private long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public void printMetrics(String label) {
        System.out.printf(
                "%-25s | Time: %8.3f ms | Memory: %6d KB%n",
                label,
                getElapsedTimeMs(),
                getMemoryUsedKB()
        );
    }

    public void writeMetrics(int inputSize, int majorityElement) {
        boolean append = csvFile.exists();
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            if (!append) {
                writer.write("InputSize,TimeMillis,MajorityElement,MemoryKB\n");
            }
            writer.write(inputSize + "," + getElapsedTimeMs() + "," + majorityElement + "," + getMemoryUsedKB() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
