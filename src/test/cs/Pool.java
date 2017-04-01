package test.cs;

import java.util.concurrent.Semaphore;

public class Pool {

    private static final int MAX_AVAILABLE = 100;

    private final Semaphore available = new Semaphore(Pool.MAX_AVAILABLE, true);// true可以指定是否公平

    public Object getItem() throws InterruptedException {

        this.available.acquire();

        return getNextAvailableItem();

    }

    public void putItem(final Object x) {

        if (markAsUnused(x)) {
            this.available.release();
        }

    }

    // Not a particularly efficient data structure; just for demo

    protected Object[] items = new Object[0];

    protected boolean[] used = new boolean[Pool.MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {

        for (int i = 0; i < Pool.MAX_AVAILABLE; ++i) {

            if (!this.used[i]) {

                this.used[i] = true;

                return this.items[i];

            }

        }

        return null; // not reached

    }

    protected synchronized boolean markAsUnused(final Object item) {

        for (int i = 0; i < Pool.MAX_AVAILABLE; ++i) {

            if (item == this.items[i]) {

                if (this.used[i]) {

                    this.used[i] = false;

                    return true;

                } else {
                    return false;
                }

            }

        }

        return false;

    }

}
