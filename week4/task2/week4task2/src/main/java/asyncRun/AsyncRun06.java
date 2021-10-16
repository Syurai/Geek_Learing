package asyncRun;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可重入锁
 * 参考synchronized，也可以通过可重入锁ReentrantLock，但是需要先让计算线程抢到锁，之后main线程会被阻塞直到计算线程执行完毕。
 */
public class AsyncRun06 {
	
	private static final ReentrantLock lock = new ReentrantLock(true);
	
    public static void main(String[] args) throws InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		TimeUnit.MILLISECONDS.sleep(1);
		lock.lock();
		try {
			System.out.println("***");
		} finally {
			lock.unlock();
		}
		
		int result = sumThread.getResult();
        
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread extends Thread {

		private Integer result;

		public Integer getResult() {
			return result;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				result = sum();
			} finally {
				lock.unlock();
			}
		}
	}
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
