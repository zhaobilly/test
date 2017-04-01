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
                this.cb.await(); // �ȴ��������Ӳ�ժ���
                box();
                this.cb.await(); // �ȴ���������װ�����
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void pick() {

            System.out.println("��ժ��" + this.i + "��������ɣ�");
        }

        public void box() {

            System.out.println("��" + this.i + "������װ����ɣ�");
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
