import java.util.concurrent.CountDownLatch;

public class ProcessThread implements Runnable {
    private CountDownLatch latch;
    private Long workDuration;
    private String name;

    ProcessThread(String name, CountDownLatch latch, Long duration) {
        this.name = name;
        this.latch = latch;
        this.workDuration = duration;
    }

    @Override
    public void run() {
        try {
            System.out.println(name +" Processando "+ workDuration/1000 + " segundos...");
            Thread.sleep(workDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+ " Execução terminada!");

        latch.countDown();
    }
}
