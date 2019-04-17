package basecode;

import java.util.concurrent.CyclicBarrier;

public class CuclicBarThread implements Runnable {

        CyclicBarrier barrier;

        public CuclicBarThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i < 5; i++) {
		    Thread.sleep(10);
                }
                System.out.println(Thread.currentThread().getName() + " :: Barreira 1: Esperando o primeiro estágio ser completado");
                barrier.await();
                for (int i = 1; i < 5; i++) {
                    Thread.sleep(200);
                }
                System.out.println(Thread.currentThread().getName() + " :: Barreira 2: Esperando o segundo estágio ser completado");
                barrier.await();

                for (int i = 1; i < 5; i++) {
		    Thread.sleep(10);
                }
                System.out.println(Thread.currentThread().getName() + " :: Barreira 3: Esperando o terceiro estágio ser completado");
                barrier.await();

                System.out.println(Thread.currentThread().getName()+" :: Thread encerrada");
            } catch (Exception ex) {
                ex.printStackTrace();
            }



        }
    }
