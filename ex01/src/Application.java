import java.util.concurrent.CountDownLatch;

public class Application {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);


        new Thread(new ProcessThread("Thread 1",latch, 2000L)).start();
        new Thread(new ProcessThread("Thread 2",latch, 6000L)).start();
        new Thread(new ProcessThread("Thread 3",latch, 4000L)).start();

        System.out.println("Espera Threads filhas executarem e notificarem....");

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas Threads executaram....");

        System.out.println("Voltando para a Thread mãe....");

    }
}