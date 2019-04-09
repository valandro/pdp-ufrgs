package exemplos;
import exemplos.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarr {


        public static void main(String[] args) {


            CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                private int count =1;
                @Override
                public void run() {
                    System.out.println("Barreira superada..!! "+(count++));
                }
            });

            for (int i = 1; i <= 3; i++) {

                Thread t = new Thread(new CuclicBarThread(barrier));
                t.start();

            }



        }
    }
