import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarr {
    public CyclicBarr() {
    }

    public static void main(String[] var0) {
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = -1;
        matrix[1][0] = 2;
        matrix[1][1] = 2;
        AtomicInteger det = new AtomicInteger(0);

        CyclicBarrier var1 = new CyclicBarrier(2, new Runnable() {
            private int count = 1;

            public void run() {
                System.out.println("Barreira superada..!! " + this.count++);
                System.out.println("Determinante = " + det);
            }
        });

        System.out.println("AE");
        for(int var2 = 1; var2 <= 2; ++var2) {
            Thread var3 = new Thread(new CuclicBarThread(var1, matrix, var2, det));
            var3.start();
        }
    }
}
