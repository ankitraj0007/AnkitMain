package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
implement parallel matrix multiplication using:
ExecutorService for thread management.
CountDownLatch so the main thread waits until all rows of the result are computed.
**/
public class ParallelMatrixMultiplication {

    public static int[][] parallelMultiply(int[][] A, int[][] B, int numThreads) throws InterruptedException {
        int m = A.length;         // Rows in A
        int n = A[0].length;      // Columns in A / Rows in B
        int p = B[0].length;      // Columns in B

        int[][] C = new int[m][p];
        CountDownLatch latch = new CountDownLatch(m); // one latch per row

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int row = 0; row < m; row++) {
            final int r = row;
            executor.submit(() -> {
                try {
                    for (int col = 0; col < p; col++) {
                        int sum = 0;
                        for (int k = 0; k < n; k++) {
                            sum += A[r][k] * B[k][col];
                        }
                        C[r][col] = sum;
                    }
                } finally {
                    latch.countDown(); // mark row as done
                }
            });
        }

        latch.await(); // Wait for all rows to finish
        executor.shutdown();

        return C;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int[][] C = parallelMultiply(A, B, 2);

        System.out.println("Resultant Matrix:");
        for (int[] row : C) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
