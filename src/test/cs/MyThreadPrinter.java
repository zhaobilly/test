package test.cs;


public class MyThreadPrinter {

    public static void main(final String[] args) {

        MyLock lock = new MyLock();

        Thread a = new Thread(new MyPrinter("A", "B", lock));
        Thread b = new Thread(new MyPrinter("B", "C", lock));
        Thread c = new Thread(new MyPrinter("C", "A", lock));

        a.start();
        b.start();
        c.start();

        lock.setHolder("A");
    }

    static class MyPrinter implements Runnable {

        private String myName;

        private String nextName;

        private final MyLock lock;

        public MyPrinter(final String myName, final String nextName, final MyLock lock) {
            this.myName = myName;
            this.nextName = nextName;
            this.lock = lock;
        }

        public void run() {

            int count = 10;
            while (count > 0) {
                //
                if (this.lock != null && this.lock.getHolder() != null && this.lock.getHolder().equals(this.myName)) {
                    // synchronized (this.lock) {
                    System.out.println(this.myName);
                    count--;
                    this.lock.setHolder(this.nextName);
                    // }
                }

            }
        }
    }

    static class MyLock {

        public MyLock() {}

        private String holder;

        public String getHolder() {

            return this.holder;
        }

        public void setHolder(final String holder) {

            this.holder = holder;
        }
    }

}
