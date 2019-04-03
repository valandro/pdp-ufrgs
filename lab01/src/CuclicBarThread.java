import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CuclicBarThread implements Runnable {
    private CyclicBarrier barrier;
    private int[][] matrix;
    private AtomicInteger det;
    private int threadNumber;

    public CuclicBarThread(CyclicBarrier var1, int[][] matrix, Integer threadNumber, AtomicInteger det) {
        this.barrier = var1;
        this.matrix = matrix;
        this.threadNumber = threadNumber;
        this.det = det;
    }


    public void run() {
        try {
            if(threadNumber == 1){
                det.getAndAdd(matrix[0][0] * matrix[1][1]);
            } else {
                det.getAndAdd(- matrix[0][1] * matrix[1][0]);
            }

            System.out.println(Thread.currentThread().getName() + " :: Barreira 1: Esperando o primeiro estágio ser completado");
            barrier.await();

        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}