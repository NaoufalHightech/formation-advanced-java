package jour2.ex3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex3 {
    private Lock lock = new ReentrantLock();

    public void methode() {
        lock.lock();
        try {
            System.out.println("Mon traitement : " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }
}
