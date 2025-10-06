# Boyer-Moore Majority Vote (Single-Pass)

This project implements the **Boyer-Moore Majority Vote algorithm** in Java, which detects the majority element in an array using a **single pass**.

> ⚠️ **Note:** Because this algorithm uses only a single pass, it may sometimes produce an incorrect result if no true majority exists or in certain edge cases.

---

## Overview

The **Boyer-Moore Majority Vote algorithm** is designed to find the element that appears more than `n/2` times in an array of size `n`. It works efficiently in **O(n) time** and **O(1) space** using a **single pass**.

Key points:

- **Single-Pass Algorithm:** The algorithm iterates through the array only once.
- **Candidate Selection:** It maintains a `candidate` element and a `count`. The candidate is updated whenever the count drops to zero.
- **Potential Inaccuracy:** If there is no true majority element, the algorithm will return the last candidate, which may not be the correct majority.

---

## Features

- Single-pass detection of a majority element.
- Performance tracking (time and memory) for benchmarking.
- Benchmarking on arrays of different sizes.
- Unit tests covering edge cases, sorted/reverse arrays, and random arrays.

---

## Project Structure
```
├── src/main/java/ 
│ ├── algorithms/[AlgorithmName].java
│ ├── metrics/PerformanceTracker.java
│ └── cli/BenchmarkRunner.java
├── src/test/java/
│ └── algorithms/[AlgorithmName]Test.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance-plots/
├── README.md
└── pom.xml
```


---

## Benchmarking

The project includes a **benchmark runner** that measures:

- Execution time in milliseconds
- Memory usage in KB
- The computed majority element

Benchmark results are saved to `performance/bench_results.csv` and can be used for performance analysis.
![img.png](../Boyer-Moore_Majoruty_Vote/src/img.png)
Example usage:

```bash
mvn compile exec:java
```

# Boyer–Moore Majority Vote Algorithm

## Running Tests

Unit tests are implemented using **JUnit 5**. To run the tests:

```bash
mvn test
```
## Test Coverage

The tests cover a variety of scenarios:

- Empty arrays
- Single-element arrays
- Arrays with duplicates
- Sorted and reverse-sorted arrays
- Randomly generated arrays
- Comparison with frequency counting (for verification)

## Single-Pass Limitation Example

The Boyer–Moore Majority Vote algorithm is a **single-pass algorithm**,  
which may sometimes return an incorrect majority candidate. For example:
```bash
int[] arr = {5, 5, 4, 4, 4, 3, 3};
int result = BoyerMooreMajorityVote.findMajority(arr, tracker);
System.out.println(result);
```
Might output 3 instead of 4

## Explanation

- The algorithm maintains only a **candidate** and a **count**.
- If the true majority does not exceed half of the array, the final candidate may **not actually be the majority**.
- This behavior is expected in a **single-pass approach**.


