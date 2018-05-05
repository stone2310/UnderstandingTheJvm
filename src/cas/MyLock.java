package cas;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by stone on 2018/1/6.
 */
public class MyLock {
    private static  AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private static AtomicInteger i = new AtomicInteger(1);

    public static void  lock(){
        boolean b = atomicBoolean.compareAndSet(false, true);
        System.out.println("b:"+b);
        boolean b1 = i.compareAndSet(1, 2);
        System.out.println("b1:"+b1);
        System.out.println("i:"+i);
    }
    public static void main(String[] args) {
        // MyLock myLock = new MyLock();
        // myLock.
        lock();
    }
}
