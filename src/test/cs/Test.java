package test.cs;


public class Test {

    public static void main(final String[] args) {

        String[] names = {"A", "B", "C"};
        for (int i = 0; i < 3; i++) {
            new MyThread(names[i], i).start();
        }

        String s1 = "abcd";
        StringBuffer sb1 = new StringBuffer("abcd");
        int val = 3;
        System.out.println(s1 + val);

    }

    static class MyThread extends Thread {

        private static Integer counter = 0;

        private String name;

        private int index;

        public MyThread(final String name, final int index) {
            this.name = name;
            this.index = index;
        }

        public void run() {

            while (true) {
                synchronized (MyThread.counter) {
                    if (this.index == MyThread.counter) {
                        System.out.println(this.name);
                        MyThread.counter++;
                        break;
                    }
                }
            }
        }

    }
}
