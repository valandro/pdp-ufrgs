import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarr {
    public CyclicBarr() {
    }

    public static void main(String[] var0) {
        int numberThreads = 5;
        int[][] matrix = new Matrix(numberThreads).getMatrix();
        AtomicInteger sum = new AtomicInteger(0);

        CyclicBarrier var1 = new CyclicBarrier(numberThreads, new Runnable() {
            private int count = 1;

            public void run() {
                System.out.println("Barreira superada " + this.count++ + " ..!! ");
                System.out.println("Soma de todos elementos = " + sum);
            }
        });

        for(int var2 = 1; var2 <= numberThreads; ++var2) {
            Thread var3 = new Thread(new CuclicBarThread(var1, matrix, var2, sum));
            var3.start();
        }
    }
}
