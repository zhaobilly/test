package test.cs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Orange {

    public static class PickOrange implements Runnable {

        private int i;

        private CyclicBarrier cb;

        public PickOrange(final int i, final CyclicBarrier cb) {
            this.i = i;
            this.cb = cb;

        }

        public void run() {

            try {
                pick();
                this.cb.await(); // 等待所有橘子采摘完毕
                box();
                this.cb.await(); // 等待所有橘子装箱完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void pick() {

            System.out.println("采摘第" + this.i + "个橘子完成！");
        }

        public void box() {

            System.out.println("第" + this.i + "个橘子装箱完成！");
        }
    }

    public static void main(final String[] args) {

        CyclicBarrier cb = new CyclicBarrier(5);
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            exec.submit(new Thread(new PickOrange(i, cb)));
        }
        exec.shutdown();
    }

}
