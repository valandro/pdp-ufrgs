import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CuclicBarThread implements Runnable {
    private CyclicBarrier barrier;
    private int[][] matrix;
    private AtomicInteger sum;
    private int threadNumber;
    private final static int MATRIX_HEIGHT = 3;

    CuclicBarThread(CyclicBarrier var1, int[][] matrix, Integer threadNumber, AtomicInteger sum) {
        this.barrier = var1;
        this.matrix = matrix;
        this.threadNumber = threadNumber;
        this.sum = sum;
    }


    public void run() {
        try {
            for (int el = 0; el < MATRIX_HEIGHT; el++) {
                this.sum.getAndAdd(matrix[threadNumber - 1][el]);
            }

            System.out.println(Thread.currentThread().getName() + " :: Barreira 1: Soma de todos elementos da coluna!!");
            barrier.await();

        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}