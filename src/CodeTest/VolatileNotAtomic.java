package CodeTest;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNotAtomic {
    private static volatile AtomicInteger count = new AtomicInteger(1);
    private static final int NUMBER = 10000 ;

    public static void main (String [ ] args) {
        Thread subtractThread = new SubtractThread();

        subtractThread.start();

        for ( int i = 0 ; i < NUMBER ; i++) {
            synchronized (VolatileNotAtomic.class) {
                count.getAndIncrement() ;
            }
        }
        // 等待减法线程结束
        while (subtractThread.isAlive()){
            System.out.println( "count最后的值为：" + count) ;
        }
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < NUMBER ; i ++){
                synchronized (VolatileNotAtomic.class) {
                    count.getAndDecrement();
                }
            }
        }
    }
}
